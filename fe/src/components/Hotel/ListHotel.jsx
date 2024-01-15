import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { Navigate } from "react-router-dom";
import styles from './styles.module.css';
import { request } from '../../axios_helper';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';

class ListHotel extends Component {

  constructor(props) {
    super(props);
    this.state = {
      hotels: [],
      searchKeyword: "",
    };
  }

  componentDidMount() {
    request(
      "GET",
      "api/hotels"
    ).then((response) => {
      this.setState({ hotels: response.data.data })
      console.log(response.data.data)
    })
  }

  remove = (id) => {
    request("DELETE", `/api/hotels/${id}`)
      .then(response => {
        console.log(response.data)
        alert(`User delete successfully with ${response.data.username}`);
        window.location.reload();
      })
      .catch(error => {
        alert(`User delete error with ${id}`);
        window.location.reload();
      });
  }

  render() {
    const { hotels, searchKeyword } = this.state;

    //Filter users based on the search keyword
    const filteredUsers = hotels.filter(hotel =>
      hotel.name.toLowerCase().includes(searchKeyword.toLowerCase())
    );
    return (
      <div>
        <div class="container">
          <input
            type="text"
            placeholder="Nhập từ khóa tìm kiếm..."
            value={this.state.searchKeyword}
            onChange={this.handleSearchChange}
          />
          <table className="table table-hover table-bordered js-copytextarea dataTable no-footer" cellpadding="0"
            cellspacing="0" border="0" id="sampleTable" role="grid" aria-describedby="sampleTable_info">
            <thead>
              <tr>
                <th>Id</th>
                <th>Address</th>
                <th>Description</th>
                <th>ImageUrl</th>
                <th>Name</th>
                <th>Rooms</th>
                <th>Option</th>
              </tr>
            </thead>
            <tbody>
                {filteredUsers.map((hotels) => (
                  <tr key={hotels.id} role="row" className="odd">
                    <td key={hotels.id}>{hotels.id}</td>
                    <td key={hotels.address}>{hotels.address}</td>
                    <td key={hotels.description}>{hotels.description}</td>
                    <td key={hotels.imageUrl}>{hotels.imageUrl}</td>
                    <td key={hotels.name}>{hotels.name}</td>
                    <td key={hotels.rooms}>{hotels.rooms}</td>
                    <td>
                      <ButtonGroup>
                        <Button style={{ "margin-right": '5px' }} tag={Link} to={"/hotels/" + hotels.id} className={`${styles.trash}  btn btn-primary btn-sm `}
                          type="button" title="Update"
                        > <i class="fas fa-edit"></i>  Edit </Button>

                        <Button className={`${styles.btn_primary}  btn btn-primary btn-sm `}
                          onClick={() => this.remove(hotels.id)}> <i class="fas fa-trash-alt"></i> Delete</Button>
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


export default ListHotel;
