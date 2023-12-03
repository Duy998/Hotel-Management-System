import React, { Component } from 'react';
import { request } from '../../axios_helper';
import { Navigate } from "react-router-dom";
import styles from './styles.module.css';

class Register extends Component {

    constructor(props) {
        super(props);

        this.state = {
            username: '',
            password: '',
            confirm_password: '',
            email: '',
            phone: '',
            successMessage: '',
            registrationSuccess: false,
            redirectToLogin: false  // Thêm trường để điều hướng
        };
    }
    
    // Cập nhật state khi người dùng nhập vào các trường
    handleChange = (event) => {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }

    // Kiểm tra xác nhận mật khẩu
    isPasswordMatch = () => {
        const { password, confirm_password } = this.state;
        return password === confirm_password;
    }

    // Xử lý khi người dùng nhấn nút đăng ký
    handleSubmit = (event) => {
        event.preventDefault();

        if (!this.isPasswordMatch()) {
            alert("Passwords do not match. Please check again.");
            return;
        }

        request(
            "POST",
            "/users",
            {
                userID: 10,
                fullName: this.state.username,
                passWord: this.state.password,
                email: this.state.email,
                phoneNumber: this.state.phone
            }).then((response) => {
                this.setState({ registrationSuccess: true, successMessage: "Registration successful!", redirectToLogin: true }, () => {
                    // Callback function to execute after state is updated
                    alert(this.state.successMessage);
                    // Perform any other actions you need here
                });
                
            })
            .catch((error) => {
                console.error("Error registering user:", error);
            });

    }
   
    handleOkButtonClick = () => {
        this.setState({ navigateToUsers: true });
    }

    render() {
        if (this.state.registrationSuccess) {
            // Nếu redirectToUsers là true, chuyển hướng đến trang Users
            return <Navigate to="/" />;
        }
        return (   
            
            <div>
                <div className={styles.register_form_container}>
                    <div className="panel-heading">
                        <div className="panel-title text-center">  
                            <h1 className="h2">REGISTER</h1>
                            <hr />
                        </div>
                    </div> 
                    <div className="main-login main-center">
                                <form onSubmit={this.handleSubmit} className='form-horizontal'>
                                    {/* ===username=== */}
                                    <div className="form-group">
                                        <label className='cols-sm-2 control-label'>UserName</label>
                                        <div className='cols-sm-10'>
                                            <span className="input-group-addon"><i className="fa fa-user fa" aria-hidden="true"></i></span>
                                            <input 
                                                style={{ fontSize: '15px' }}
                                                className="form-control"
                                                type="text"
                                                name="username"
                                                placeholder="Enter your username..."
                                                value={this.state.username}
                                                onChange={this.handleChange} 
                                            />
                                        </div>
                                    </div>
                                    {/* password */}
                                    <div className="form-group">
                                        <label>Password</label>
                                        <input
                                            style={{ fontSize: '15px' }}
                                            className="form-control form-control-lg"
                                            type="password"
                                            name="password"
                                            placeholder="Enter your password..."
                                            value={this.state.password}
                                            onChange={this.handleChange}
                                        />
                                    </div>
                                    {/* confirm password */}
                                    <div className="form-group">
                                        <label>Confirm Password</label>
                                        <input
                                            style={{ fontSize: '15px' }}
                                            className="form-control form-control-lg"
                                            type="password"
                                            name="confirm_password"
                                            placeholder="Enter your password again..."
                                            value={this.state.confirm_password}
                                            onChange={this.handleChange}
                                        />
                                    </div>
                                    {/* email */}
                                    <div className="form-group">
                                        <label>Email</label>
                                        <input
                                            style={{ fontSize: '15px' }}
                                            className="form-control form-control-lg"
                                            type="text"
                                            name="email"
                                            placeholder="Enter your email..."
                                            value={this.state.email}
                                            onChange={this.handleChange}
                                        />
                                    </div>
                                    {/* phone */}
                                    <div className="form-group">
                                        <label>Phone</label>
                                        <input
                                            style={{ fontSize: '15px' }}
                                            className="form-control form-control-lg"
                                            type="text"
                                            name="phone"
                                            placeholder="Enter your phone..."
                                            value={this.state.phone}
                                            onChange={this.handleChange}
                                        />
                                    </div>
                                    <div className="text-center mt-2">
                                        <button type="submit" className="btn btn-lg btn-primary">Sign Up</button>
                                    </div>
                                </form> 
                    </div> 
                </div>
        </div>


        );
    }
}

export default Register;