import PriceProductList from "./Components/PriceProductList";
// import PriceProductList from './components/PriceProductList';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import AddProduct from "./Products/AddProduct";
import UpdateProduct from "./Products/UpdateProduct";
import ViewProduct from "./Products/ViewProduct";
// import Header from './Components/Header';

function App() {
  return (
    <div className="container">
      <Router>
        {/* <Header/> */}
        <Routes>
          <Route exact path="/" element={<PriceProductList />} />
          <Route exact path="addProduct" element={<AddProduct />} />
          <Route exact path="updateProduct/:id" element={<UpdateProduct />} />
          <Route exact path="viewProduct/:id" element={<ViewProduct />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
