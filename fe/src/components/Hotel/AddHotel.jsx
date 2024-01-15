import React, { Component } from 'react';
import { request } from '../../axios_helper';
import { Navigate } from "react-router-dom";
import styles from './styles.module.css';

class AddHotel extends Component {

    constructor(props) {
        super(props);
        this.state = {
            address: '',
            description: '',
            imageUrl: '',
            name: '',
            rooms: '',
            successMessage: '',
            addSuccess: false,
            redirectToListUser: false
        };
    }

    // Cập nhật state khi người dùng nhập vào các trường
    handleChange = (event) => {
        const { name, value } = event.target;
        this.setState({ [name]: value });
        console.log(this.state);
    }

    handleSubmit = (event) => {
        event.preventDefault();
        console.log(this.state);
        request(
            "POST",
            "/api/hotels",
            {
                name: this.state.name,
                address: this.state.address,
                description: this.state.description,
                imageUrl: this.state.imageUrl
                
            }).then((response) => {
                this.setState({ addSuccess: true, successMessage: "Add user successful!", redirectToListUser: true }, () => {
                    // Callback function to execute after state is updated
                    alert(this.state.successMessage);
                    // Perform any other actions you need here
                });

            })
            .catch((error) => {
                console.error("Error registering user:", error);
                alert("Error registering user");
            });

    }


    render() {
        if (this.state.addSuccess) {
            // Nếu redirectToUsers là true, chuyển hướng đến trang Users
            return <Navigate to="/admin" />;
        }
        return (

            <div className="main-login main-center">
                <form onSubmit={this.handleSubmit} className='form-horizontal'>
                    {/* ===fullname=== */}
                    <div className="form-group">
                        <label className='cols-sm-2 control-label'>address</label>
                        <div className='cols-sm-10'>
                            <span className="input-group-addon"><i className="fa fa-user fa" aria-hidden="true"></i></span>
                            <input
                                style={{ fontSize: '15px' }}
                                className="form-control"
                                type="text"
                                name="address"
                                placeholder="Enter your full name..."
                                value={this.state.address}
                                onChange={this.handleChange}
                            />
                        </div>
                    </div>
                    {/* ===username=== */}
                    <div className="form-group">
                        <label className='cols-sm-2 control-label'>description</label>
                        <div className='cols-sm-10'>
                            <span className="input-group-addon"><i className="fa fa-user fa" aria-hidden="true"></i></span>
                            <input
                                style={{ fontSize: '15px' }}
                                className="form-control"
                                type="text"
                                name="description"
                                placeholder="Enter your description..."
                                value={this.state.description}
                                onChange={this.handleChange}
                            />
                        </div>
                    </div>
                    {/* password */}
                    <div className="form-group">
                        <label>imageUrl</label>
                        <input
                            style={{ fontSize: '15px' }}
                            className="form-control form-control-lg"
                            type="imageUrl"
                            name="imageUrl"
                            placeholder="Enter your imageUrl..."
                            value={this.state.imageUrl}
                            onChange={this.handleChange}
                        />
                    </div>
                    {/* confirm password */}
                    <div className="form-group">
                        <label>name</label>
                        <input
                            style={{ fontSize: '15px' }}
                            className="form-control form-control-lg"
                            type="name"
                            name="name"
                            placeholder="Enter your name again..."
                            value={this.state.name}
                            onChange={this.handleChange}
                        />
                    </div>
                    {/* email */}
                    <div className="form-group">
                        <label>rooms</label>
                        <input
                            style={{ fontSize: '15px' }}
                            className="form-control form-control-lg"
                            type="text"
                            name="rooms"
                            placeholder="Enter your rooms..."
                            value={this.state.rooms}
                            onChange={this.handleChange}
                        />
                    </div>
                    <div className="text-center mt-2">
                        <button type="submit" className="btn btn-lg btn-primary">Add Hotel</button>
                    </div>
                </form>
            </div>


        );
    }
}

export default AddHotel;