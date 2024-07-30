import { view } from '../redux/action'
import { useDispatch } from 'react-redux'
import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom'
import '../style.css'


const HandelPrice = (UID, price) => {

  for (let index in price) {
    if (price[index].productMasterUID === UID) {
      return [price[index].regularPrice, price[index].currentPrice]
    }
  }

}

const PriceProductList = () => {

  const dispatch = useDispatch();
  const [product, setproduct] = useState([]);
  const [price, setprice] = useState([]);
  const getPriceProductList = async () => {

    try {

      const res = await axios.get('http://localhost:8080/priceProduct');
      const actualdata = res.data;
      // setPriceProduct(actualdata);
      setproduct(actualdata.products);
      setprice(actualdata.prices);
    } catch (error) {

      console.log(error);

    }
  }

  useEffect(() => {

    getPriceProductList();

  }, []);

  const DeletePriceProduct = async (productMasterUID) => {


    await axios.delete(`http://localhost:8080/deletePriceProduct/${productMasterUID}`);

    getPriceProductList();
  }

  return (
    <>

      <h1 className="text-center mt-5" style={{ fontSize: 50 }}>Products List</h1>
      <div className="row Size">
        <table className="table table-striped table-bordered">
          <thead style={{ backgroundColor: "aqua" }}>

            <tr className='text_position'>
              <th>S.NO</th>
              <th>Name</th>
              <th>DisplayName</th>
              <th>Description</th>
              <th>RegularPrice</th>
              <th>CurrentPrice</th>
              <th>Skuid</th>
              <th >Action</th>
            </tr>
          </thead>

          <tbody>

            {
              product?.map((obj, index) => (

                <tr key={obj.id} className='text_position'>
                  <td>{index + 1}</td>
                  <td>{obj.name}</td>
                  <td>{obj.displayName}</td>
                  <td>{obj.discription}</td>
                  <td>{(HandelPrice(obj.productMasterUID, price))[0]}</td>
                  <td>{(HandelPrice(obj.productMasterUID, price))?.[1]}</td>
                  <td>{obj.skuid}</td>
                  <td className='text_position'>

                    <Link className="btn btn-primary mx-2 Size button_bor" onClick={() => {
                      
                      let handlePrice = HandelPrice(obj.productMasterUID, price);
                      dispatch(view({ ...obj, handlePrice }))
                      
                    }}
                      to={`/viewProduct/${obj.productMasterUID}`}
                    >

                      View</Link>

                    <Link className="btn btn-warning mx-2 Size button_bor" to={`/updateProduct/${obj.productMasterUID}`}>Update</Link>
                    <button type="button" className="mx-2 Size button_bor" onClick={() => DeletePriceProduct(obj.productMasterUID)}>
                      <i class="material-icons" style={{ color: "red" }}>delete</i>
                    </button>

                  </td>
                </tr>
              ))
            }

          </tbody>
        </table>
      </div>

      <Link className="btn btn-primary button_bor" style={{ fontSize: 20 }} to="/addProduct">Add Product</Link>
    </>
  )
}

export default PriceProductList