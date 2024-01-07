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
    isPasswordMatch = (password, confirm_password) => {
        return password === confirm_password;
    }

    verifyEmail= (email) => {
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return emailRegex.test(email);

    }

    isValidLength = () => {
        const { username, password } = this.state;
        const minLength = 8; // Độ dài tối thiểu cho username và password
    
        return username.length >= minLength && password.length >= minLength;
    }

    // Kiểm tra trường input không được để trống
    isNotEmpty = (value) => {
        return value.trim() !== ''; // Kiểm tra xem giá trị sau khi loại bỏ các khoảng trắng có khác rỗng không
    }
    isValidPhone= (value)=> {
        const phoneRegex = /^\d{0,10}$/;
        return phoneRegex.test(value);
    }
    // Xử lý khi người dùng nhấn nút đăng ký
    handleSubmit = (event) => {
        event.preventDefault();
        const { username, password, confirm_password, email, phone } = this.state;

        if (!this.isNotEmpty(username) || !this.isNotEmpty(password) || !this.isNotEmpty(confirm_password) || !this.isNotEmpty(email) || !this.isNotEmpty(phone)) {
            alert("All fields must be filled. Please check again.");
            return;
        }
        if (!this.isPasswordMatch(password, confirm_password)) {
            alert("Passwords do not match. Please check again.");
            return;
        }
        
        if (!this.verifyEmail(email)){
            alert("Invalid email address. Please enter a valid email.");
            return;
        }

        if (!this.isValidLength()) {
            alert("Username and password must be at least 8 characters long.");
            return;
        }

        if(!this.isValidPhone(phone)){
            alert("Phone Invalid. Please enter a valid phone.");
            return;
        }
        request(
            "POST",
            "/api/user/register",
            {
                userName: this.state.username,
                fullName: this.state.username,
                password: this.state.password,
                email: this.state.email,
                phone: this.state.phone
            }).then((response) => {
                this.setState({ registrationSuccess: true, successMessage: "Registration successful!", redirectToLogin: true }, () => {
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