import logo from './logo.svg';
import React from 'react';
import './App.css';
import Login from './components/User/Login';
import Register from './components/User/Register';
import NotFound from './components/NotFound'
import Users from './components/User/Users'
import UpdateUser from './components/User/UpdateUser'
import MainApp from './components/Admin/MainApp';
import Customer from './components/Customer/DetailCustomer'
import UpdateHotels from './components/Hotel/UpdateHotel'
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';


const App = () => {
    return (
      <Router>
          <Routes>
            <Route exact path="/" element={<Login/>}/>
            <Route exact path="/admin" element={<MainApp/>}/>
            <Route exact path="/admin/:id" element={<MainApp/>}/>
            <Route exact path="/register" element={<Register/>}/>
            <Route exact path="/users" element={<Users/>}/>
            <Route path="/*" element={<NotFound/>}/>
            <Route path="/user/:id" exact={true} element={<UpdateUser/>}/>
            <Route path="/customer/:id" element={<Customer />} />
            <Route path="/hotels/:id" element={<UpdateHotels />} />

          </Routes>
      </Router>
    );
  }
  

export default App;