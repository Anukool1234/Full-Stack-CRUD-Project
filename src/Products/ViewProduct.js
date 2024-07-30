// import axios from "axios";
import React from "react";
import { Link} from "react-router-dom";
import '../style.css'
import {useSelector} from 'react-redux'

export default function ViewProduct() {

    const result = useSelector((state)=>state.viewData);
    
    return (

        <div className="container Size">
            <div className="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <span className="product_details">Product Details</span>

                    <div className="card">
                        <div className="card-header">
                           

                            <div className="mb-2" style={{display:"flex",backgroundColor:"white"}}>
                                <div className="col-3 text-center py-4" style={{paddingTop:"8px"}}>
                                <b className="product_heading_color mx-2 my-2">Skuid:</b> 
                                <br/> 
                                {result.skuid} 
                                </div>
                                <div className="col-3 text-center py-4" style={{paddingTop:"8px"}}>
                                <b className="product_heading_color mx-2">Name:</b> <br/> 
                                    {result.name}  
                                </div>
                                <div className="col-3 text-center py-4" style={{paddingTop:"8px"}}>
                                <b className="product_heading_color mx-2">DisplayName:</b> <br/> 
                                    {result.displayName}  
                                </div>
                                <div className="col-3 text-center py-4" style={{paddingTop:"8px"}}>
                                <b className="product_heading_color mx-2">Discription:</b> <br/> 
                                    {result.discription} 
                                </div>
                            </div>

                            <ul className="list-group list-group-flush">
                            
                                <li className="list-group-item">
                                    <b className="product_heading_color">MetaData:</b>
                                    {result?.metaData?.map((metasingle) => {
                                        return (

                                            <div key={metasingle.productMasterUID}>

                                              <div className="my-4 box_border bg-light border" style={{display:"flex"}}>

                                              <div className="col-6 text-center">
                                              <b style={{color:"blue"}}>Name:</b><br/>
                                              {metasingle.name}
                                              </div>
                                             <div className="col-6 text-center">
                                             <b style={{color:"blue"}}>value:</b><br/>
                                                {
                                                        metasingle?.values?.map(val => { 
                                                            return (
                                                                <>{val} &nbsp;</>
                                                           )
                                                             })
                                                    }
                                                </div>  
                                              </div> 
                                            </div>
                                        );
                                    })}
                                </li>
                                <div className="mt-2" style={{backgroundColor:"white"}}>
                                    <b className="product_heading_color mx-3">Taxation:</b>
                                    {result?.taxation?.map((tax) => {
                                        return (

                                            <div className="mx-3" key={tax.productMasterUID}>
                                                <div style={{textAlign:"center"}}>
                                                  <b style={{color:"red"}}>RegionCode: </b><br/>
                                                  {tax.regionCode}
                                                </div>
                                                <div className="bg-light border">
                                                    {
                                                        tax?.taxes?.map(val => { return <>
                                                        <div key={val.name+val.value}> 
                                                         <div className="box_border" style={{display:"flex"}}>

                                                         <div className="col-6 text-center">
                                                         <b style={{color:"blue"}}>Name:</b><br/>
                                                         {val.name}
                                                         </div>

                                                         <div className="col-6 text-center">
                                                         <b style={{color:"blue"}}>Value:</b><br/>
                                                        {val.value}</div>
                                                         </div>
                                                        

                                                        </div>
                                                        </> })
                                                    }
                                                </div>
                                                <br/>
                                            </div>
                                        );
                                    })}
                                </div>
           
                                <div className="mt-2" style={{display:"flex",backgroundColor:"white"}}>
                                    <div className="col-6 py-4 text-center">
                                    <b className="product_heading_color mx-2">RegularPrice:</b><br/>
                                    {result.handlePrice?.[0]}
                                    </div>
                                    <div className="col-6 py-4 text-center">
                                    <b className="product_heading_color mx-2">CurrentPrice:</b><br/>
                                    {result.handlePrice?.[1]}
                                    </div>
                                </div>

        
                            </ul>
                        </div>
                    </div>
                    <Link className="btn btn-primary my-2" style={{fontSize:20}} to={"/"}>
                        Back to Home
                    </Link>
                </div>
            </div>
        </div>
    );
}


