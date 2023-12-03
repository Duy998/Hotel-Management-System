// Listusercomponenet.jsx
import React, { Component } from 'react';
import UserService from '../services/UserService';
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
      "/users",
      {}
    ).then((response) => {
      this.setState({users: response.data})
    })
  }

  render() {
    return (
      <div>
        <h2 className="text-center">Users List</h2>
        <table className="table">
          <thead>
            <tr>
              <th>Firstname</th>
              <th>Lastname</th>
              <th>Email</th>
            </tr>
          </thead>
          <tbody>
            {this.state.users.map((user) => (
              <tr key={user.userID}>
                <td>{user.fullName}</td>
                <td>{user.passWord}</td>
                <td>{user.email}</td>
                <td>{user.phoneNumber}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default Listusercomponenet;
