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

    remove = (id) => {
      request("DELETE", `/api/user/${id}`)
      .then(response => {
        // Xử lý kết quả cập nhật thành công
        console.log('User updated successfully');
        alert(`User delete successfully ưith ${id}`);
        window.location.reload();
      })
      .catch(error => {
        console.error("Lỗi khi cập nhật user:", error);
      });
    }

    render() {
        return (
          <div>

    <div class="container">
<<<<<<< HEAD
        <h1>Danh sách Nhà cung cấp</h1>
        <input
    type="text"
    placeholder="Nhập từ khóa tìm kiếm..."
    value={this.state.searchKeyword}
    onChange={this.handleSearchChange}
  />
        <table className="table table-borderd">
=======
        <table className="table table-hover table-bordered js-copytextarea dataTable no-footer" cellpadding="0"
      cellspacing="0" border="0" id="sampleTable" role="grid" aria-describedby="sampleTable_info">
>>>>>>> 4ae2ec9 (Update UI)
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
                    <tr key={user.id} role="row" className="odd">
                        <td key={user.fullName}>{user.fullName}</td>
                        <td key={user.userName}>{user.userName}</td>
                        <td key={user.password}>{user.password}</td>
                        <td key={user.email}>{user.email}</td>
                        <td key={user.phone}>{user.phone}</td>
                        <td className="table-td-center">
                        <ButtonGroup>
                            <Button style={{ "margin-right": '5px' }} tag={Link} to={"/user/" + user.id} className={ `${styles.trash }  btn btn-primary btn-sm ` } 
                                type="button" title="Update" 
                                 > <i class="fas fa-edit"></i>  Edit </Button>

                            <Button className={ `${styles.btn_primary }  btn btn-primary btn-sm ` } 
                            onClick={() => this.remove(user.id)}> <i class="fas fa-trash-alt"></i> Delete</Button>
                        </ButtonGroup>
                        </td> 
                    </tr>
                    ))}




            </tbody>
        </table>
    </div>
    </div>
        );
    }
    handleSearchChange = (event) => {
      this.setState({ searchKeyword: event.target.value });
    };    
}


export default Users;
