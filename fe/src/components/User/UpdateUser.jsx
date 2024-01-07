import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { Navigate } from 'react-router-dom'; // Corrected import
import styles from './styles.module.css';
import { request } from '../../axios_helper';

class UpdateUser extends Component {

  constructor(props) {
    super(props);
  
    this.state = {
      users: [],
    };
  }

  render() {
    return (
      <div className="container"> {/* Corrected class to className */}
        <h1>Danh sách Nhà cung cấp</h1>
      </div>
    );
  }

}

export default UpdateUser;
