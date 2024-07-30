import axios from "axios";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { cloneDeep, size } from "lodash";
import '../style.css'


function AddProduct() {

  const navigate = useNavigate();
  const [product, setproduct] = useState({});
  const [price, setprice] = useState({});
  const [metadataArray, setMetadaArray] = useState([{}]);
  const [taxationArray, setTaxationArray] = useState([{
    regionCode: "",
    taxes: [{
      name: "",
      value: ""
    }]
  }]);


  const { skuid, name, displayName, discription } = product;
  const { productMasterUID, regularPrice, currentPrice } = price;

  const addMetadata = (e) => {
    e.preventDefault();
    setMetadaArray([...metadataArray, {
      name: "",
      values: ""
    }])
  }

  const deleteMetadata = (e, index) => {
    e.preventDefault();
    const newMetaData = cloneDeep(metadataArray);
    newMetaData.splice(index, 1);
    setMetadaArray(newMetaData);
  }

  const addTaxes = (e, taxationIndex) => {
    e.preventDefault()
    let newTaxationArray = [...taxationArray];
    newTaxationArray[taxationIndex].taxes.push({
      name: "",
      value: ""
    })
    setTaxationArray(newTaxationArray);
  }

  const addTaxation = (e) => {
    e.preventDefault();
    let newTaxationArray = [...taxationArray, { regionCode: "", taxes: [{ name: "", value: "" }] }];
    setTaxationArray(newTaxationArray)
  }

  const handleTaxationChange = (index, event) => {
    let newTaxationArray = [...taxationArray]
    newTaxationArray[index][event.target.name] = event.target.value
    setTaxationArray(newTaxationArray);

  }

  const handleTaxesChange = (taxationIndex, taxesIndex, event) => {
    let newTaxationArray = [...taxationArray]
    newTaxationArray[taxationIndex].taxes[taxesIndex][event.target.name] = event.target.value
    setTaxationArray(newTaxationArray)
  }


  const onInputChange = (e) => {
    setproduct({ ...product, [e.target.name]: e.target.value });
    setprice({ ...price, [e.target.name]: e.target.value });
  };

  const deleteTaxation = (e, taxationIndex) => {
    e.preventDefault();
    const newTaxation = cloneDeep(taxationArray);
    newTaxation.splice(taxationIndex, 1);
    setTaxationArray(newTaxation);
  }

  const deleteTaxationSystem = (e, taxationIndex, taxesIndex) => {

    e.preventDefault();
    const newTaxation = cloneDeep(taxationArray);
    if (newTaxation[taxationIndex].taxes.length == 1) {
      deleteTaxation(e, taxationIndex);
    }
    else {
      newTaxation[taxationIndex].taxes.splice(taxesIndex, 1);
      setTaxationArray(newTaxation);
    }


  }

  const handleMetadataChange = (index, event) => {

    let newData = [...metadataArray]
    newData[index][event.target.name] = event.target.value
    setMetadaArray(newData)

  }

  const onSubmit = async (e) => {
    e.preventDefault();

    product.taxation = taxationArray;


    product.metaData = metadataArray.map((item) => {
      const values = item.values.split(",")
      return { ...item, values };
    })

    const response = await axios.post("http://localhost:8080/product", product);
    console.log(response.data);
    const proMastUID = response.data.productMasterUID;
    const pricebookCopy = { ...price, productMasterUID: proMastUID }
    await axios.post("http://localhost:8080/price", pricebookCopy);
    navigate("/");
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border roundeed p-4 mt-2 shadow">
          <h2 className="text-center m-4" style={{fontSize:40}}>Add Products</h2>

          <form onSubmit={onSubmit} className="Size">
            <div className="mb-3">
              <label htmlFor="skuid" className="form-label">Skuid</label>
              <input type={Number} className="form-control" required placeholder="Enter skuid" name="skuid" value={skuid} onChange={(e) => onInputChange(e)}
              />
            </div>

            <div className="mb-3">
              <label htmlFor="Name" className="form-label">
                Name
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your name"
                name="name"
                value={name}
                required
                onChange={(e) => onInputChange(e)}
              />
            </div>

            <div className="mb-3">
              <label htmlFor="displayName" className="form-label">
                DisplayName
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter displayName"
                name="displayName"
                value={displayName}
                required
                onChange={(e) => onInputChange(e)}
              />
            </div>

            <div className="mb-3">
              <label htmlFor="discription" className="form-label">
                Discription
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter discription"
                name="discription"
                value={discription}
                required
                onChange={(e) => onInputChange(e)}
              />
            </div>

            <div className="mb-3">
              {/* <label htmlFor=" MetaData" className="form-label">
                MetaData
              </label> */}
              <button className="btn btn-primary mx-2 button_bor Size" onClick={addMetadata}>Add Metadata</button>
              <div className="mb-3">
                {
                  metadataArray.map((obj, index) => {
                    return (

                      <div className="box_border mt-2"  key={metadataArray[index].name + index} >
                      <button className="right_pos mt-2" onClick={(e) => deleteMetadata(e, index)}><span style={{fontSize:10}}>&#10060;</span></button>
                          <label className="mt-4 mx-3" htmlFor="name">Name:</label>
                          <br/>
                          <input type="text" name="name" className="mx-3" placeholder="Enter Metadata Name"
                            value={metadataArray[index].name}
                            required
                            onChange={(e) => handleMetadataChange(index, e)} />
                       <br/>
                          <label className="mx-3" htmlFor="values">Values:</label>
                          <br/>
                          <input type="text" name="values" className="mx-3 mb-4" placeholder="Enter Values"
                            required
                            onChange={(e) => handleMetadataChange(index, e)}
                            value={metadataArray[index].values}
                          />
                        {/* <button className="btn btn-danger mx-2 mt-1" >Remove</button> */}
                       
                      </div>

                    )
                  })
                }
              </div>
            </div>

            <div className="mb-3">

              {/* <label htmlFor="MetaData" className="form-label">
                Taxation
              </label> */}
              <button className="btn btn-primary mx-2 button_bor Size" id="taxation-btn" onClick={(e) => addTaxation(e)}>Add Taxation</button>
              {
                taxationArray.map((taxationObj, taxationIndex) => {
                  return (
                    <div className="mt-2 px-4 py-3 box_border"  key={taxationObj.name + taxationIndex}>
                    <button className="right_pos" onClick={(e) => deleteTaxation(e, taxationIndex)}><span style={{fontSize:10}}>&#10060;</span></button>
                      <label htmlFor="regionCode">RegionCode</label>
                      <br />
                      <input id="regionCode" name="regionCode" required type="text" placeholder="Enter Region Code"
                        value={taxationObj.regionCode}
                        onChange={(e) => { handleTaxationChange(taxationIndex, e) }} />

                      <button className="btn btn-primary mx-2 button_bor Size" onClick={(e) => addTaxes(e, taxationIndex)}>Add</button>
                      {/* <button className="btn btn-danger mx-2 button_bor" onClick={(e) => deleteTaxation(e, taxationIndex)}>Remove Taxation</button> */}
              
                      {
                        taxationObj.taxes.map((taxesObject, taxesIndex) => {
                          return (
                            <div  key={taxesObject.name + taxesIndex}>
                              <div className="my-5" style={{display:"flex"}}>
                              <label htmlFor="name">Name:</label>
                             
                              <input className="mx-2"  name="name" required type="text" placeholder="Enter Tax Name"
                                value={taxesObject.name}
                                onChange={(e) => { handleTaxesChange(taxationIndex, taxesIndex, e) }} />
                             
                              <label htmlFor="values"> Value: </label>
                             
                              <input className="mx-2"  name="value" required type="text" placeholder="Enter Tax Value"
                                value={taxesObject.value}
                                onChange={(e) => { handleTaxesChange(taxationIndex, taxesIndex, e) }} />
                              <button className="btn btn-danger mx-2 button_bor" onClick={(e) => deleteTaxationSystem(e, taxationIndex, taxesIndex)}>Remove</button>
                              </div>
                            </div>
                          )
                        })
                      }
                     
                    </div>
                  )
                })
              }
            </div>

            <div className="mb-3">
              <label htmlFor="regularPrice" className="form-label">
                RegularPrice
              </label>
              <input
                type={Number}
                className="form-control"
                placeholder="Enter regularPrice"
                name="regularPrice"
                value={regularPrice}
                required
                onChange={(e) => onInputChange(e)}
              />
            </div>


            <div className="mb-3">
              <label htmlFor="currentPrice" className="form-label">
                CurrentPrice
              </label>
              <input
                type={Number}
                className="form-control"
                placeholder="Enter currentPrice"
                name="currentPrice"
                value={currentPrice}
                required
                onChange={(e) => onInputChange(e)}
              />
            </div>

            <button type="submit" className="btn btn-outline-primary button_bor Size">
              Submit
            </button>
            <Link className="btn btn-outline-danger mx-2 button_bor Size" to="/">
              Cancel
            </Link>
          </form>
        </div>
      </div>
    </div>
  );
}

export default AddProduct


// useEffect(()=>{
//   loadProduct();
// },[]);



// const loadProduct = async () =>{

//   const productResponse = await axios.get(`http://localhost:8080/product/${id}`);
//   setproduct(productResponse.data);
  

//   const priceResponse = await axios.get(`http://localhost:8080/price/${id}`);
//   setprice(priceResponse.data);
//   setMetadaArray(productResponse.data.metaData);
//   setTaxationArray(productResponse.data.taxation);
//  };
