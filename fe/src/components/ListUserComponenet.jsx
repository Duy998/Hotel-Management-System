// Listusercomponenet.jsx
import React, { Component } from 'react';
import { useLocation } from 'react-router-dom';
// import UserService from '../services/UserService';
import { request } from '../axios_helper';

class Listusercomponenet extends Component {
  constructor(props) {
    super(props);

    this.state = {
      users: [],
    };
  }

  componentDidMount() {
    // UserService.getAllUsers().then((res) => {
    //   this.setState({ users: res.data });
    // });
    request(
      "GET",
      "/api/user"
    ).then((response) => {
      this.setState({users: response.data})
    })
  }

  render() {
    return (
      <div>
        {/* <p>Vai trò người dùng: {role}</p> */}
        <h2 className="text-center">Users List</h2>
        <table className="table">
          <thead>
            <tr>
              <th>Firstname</th>
              <th>Lastname</th>
              <th>Email</th>
              <th>Phone</th>
            </tr>
          </thead>
          <tbody>
            {this.state.users.map((user) => (
              <tr key={user.userID}>
                <td key={user.fullName}>{user.fullName}</td>
                <td key={user.passWord}>{user.passWord}</td>
                <td key={user.email}>{user.email}</td>
                <td key={user.phoneNumber}>{user.phoneNumber}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default Listusercomponenet;
