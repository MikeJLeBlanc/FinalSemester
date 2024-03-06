// import React, { useState, useEffect } from 'react';
// import axios from 'axios';

// const url = `https://perenual.com/api/species-list?key=sk-g7ki65b7b9c3666f13945`

// function App() {
//     const [data, setData] = useState([]);

//     const fetchData =  async () => {
//         try {
//             const response = await axios.get(url);
//             setData(response.data.data);
//         } catch (error) {
//             console.error(error);
//         }
//     }

//     useEffect(() => {
//         fetchData();
//     }, []);

//     return (
//         <div>
//             <h1>Species List</h1>
//             <ul>
//                 {data && data.map((item, index) => (
//                     <li key={index}>{item.common_name}<img src={item.default_image} alt=''></img></li>
//                 ))}
//             </ul>
//         </div>
//     );
// }

// export default App;

import "./App.css";
import CreateUser from "./components/User/CreateUser";
import ShowUser from "./components/User/ShowUser";
import { Route, Routes } from "react-router-dom";
import EditUser from "./components/User/EditUser";
import User from "./components/User/User";
import Header from "./components/Common/Header";
import Home from "./components/Layout/Home";

function App() {
  return (
    <div className="App">
      <header className="container">
        <div className="">
          <Header />
          <Routes>
          
            <Route path="/" element={<Home />} />
            <Route path="/edit-user/:id" element={<EditUser />} />
            <Route path="/user/:id" element={<User />} />
            <Route path="/create-user" element={<CreateUser />} />
            <Route path="/show-user" element={<ShowUser />} />
            
          </Routes>
          
        </div>
      </header>
    </div>
  );
}

export default App;