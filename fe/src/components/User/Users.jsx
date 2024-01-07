import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { Navigate } from "react-router-dom";
import styles from './styles.module.css';
import { request } from '../../axios_helper';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';

class Users extends Component {

    constructor(props) {
        super(props);
    
        this.state = {
          users: [],
        };
        this.state = {
          users: [],
          searchKeyword: "",
        };
      }

    componentDidMount() {
      // request(
      //   "GET",
      //   "/api/user"
      // ).then((response) => {
      //   this.setState({users: response.data})
      //   console.log(response.data)
      // })
    }

    remove = (event) => {
        // await fetch(`/api/group/${id}`, {
        //   method: 'DELETE',
        //   headers: {
        //     'X-XSRF-TOKEN': cookies['XSRF-TOKEN'],
        //     'Accept': 'application/json',
        //     'Content-Type': 'application/json'
        //   },
        //   credentials: 'include'
        // }).then(() => {
        //   let updatedGroups = [...groups].filter(i => i.id !== id);
        //   setGroups(updatedGroups);
        // });
      }

    render() {
        return (
    <div class="container">
        <h1>Danh sách Nhà cung cấp</h1>
        <input
    type="text"
    placeholder="Nhập từ khóa tìm kiếm..."
    value={this.state.searchKeyword}
    onChange={this.handleSearchChange}
  />
        <table className="table table-borderd">
            <thead>
                <tr>
                    <th>FullName</th>
                    <th>UserName</th>
                    <th>PassWord</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Option</th>
                </tr>
            </thead>
            <tbody>
                    {this.state.users.map((user) => (
                    <tr key={user.userID}>
                        <td key={user.fullName}>{user.fullName}</td>
                        <td key={user.userName}>{user.userName}</td>
                        <td key={user.password}>{user.password}</td>
                        <td key={user.email}>{user.email}</td>
                        <td key={user.phone}>{user.phone}</td>
                        <td>
                        <ButtonGroup>
                            <Button size="sm" color="primary" tag={Link} to={"/groups/" + user.userID}>Edit</Button>
                            <Button size="sm" color="danger" onClick={() => this.remove(user.userID)}>Delete</Button>
                        </ButtonGroup>
                        </td>
                    </tr>
                    ))}




            </tbody>
        </table>
    </div>
        );
    }
    handleSearchChange = (event) => {
      this.setState({ searchKeyword: event.target.value });
    };    
}


export default Users;
