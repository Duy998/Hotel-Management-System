import logo from './logo.svg';
import React from 'react';
import './App.css';
import Listusercomponenet from './components/ListUserComponenet';
import Login from './components/User/Login';
import Register from './components/User/Register';
import NotFound from './components/NotFound'
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';


const App = () => {
    return (
      <Router>
          <Routes>
            <Route exact path="/" element={<Login/>}/>
            <Route exact path="/register" element={<Register/>}/>
            <Route exact path="/users" element={<Listusercomponenet/>}/>
            <Route path="/*" element={<NotFound/>}/>
          </Routes>
      </Router>
    );
  }
  

export default App;