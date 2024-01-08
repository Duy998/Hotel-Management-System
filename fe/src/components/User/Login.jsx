import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { Navigate } from "react-router-dom";
import styles from './styles.module.css';
import { request } from '../../axios_helper';

class Login extends Component {

    constructor(props) {
        super(props);
    
        this.state = {
            username: '',
            password: '',
            statusLogin: false,
            role: 'admin'
        };
      }


    // Cập nhật state khi người dùng nhập vào các trường
    handleChange = (event) => {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }

    handleSubmit = (event) => {
        event.preventDefault();
        console.log(this.state)
        const { username, password } = this.state;
        request(
            "POST",
            "/api/user/login",
            {
                userName: username,
                password: password
            }).then((response) => {
                console.log(response.data)
                if(response.data.message){
                    alert("password or username Invalid");
                }else{
                    this.setState({ statusLogin: true });
                    this.setState({role: response.data.fullName})
                    alert("Login successful!");
                }

            })
            .catch((error) => {
                console.error("Error login user:", error);
                alert("password or username sai");
            });        
    }  

    render() {
        const { statusLogin, role } = this.state;
        if (statusLogin) {
            // Nếu statusLogin là true, chuyển hướng đến trang Users
            return <Navigate to="/admin#"/>;
        }
        return (
            <div className={styles.register_form_container}>
                <div className="panel-heading">
                    <div className="panel-title text-center">  
                        <h1 className="h2">LOGIN</h1>
                        <hr />
                    </div>
                </div>  
                <div className="main-login main-center">
                    <form onSubmit={this.handleSubmit} className='form-horizontal'>
                        <div className="form-group">
                        <label className='cols-sm-2 control-label'>UserName</label>
                            <div className='cols-sm-10'>
                                <input 
                                style={{ fontSize: '15px' }}
                                className="form-control form-control-lg" 
                                type="text" 
                                name="username" 
                                placeholder="Enter your name" 
                                value={this.state.username} onChange={this.handleChange} />
                            </div>    
						</div>
						<div className="form-group">
							<label>Password</label>
                            <div className='cols-sm-10'>
                                <input 
                                style={{ fontSize: '15px' }}
                                className="form-control form-control-lg" 
                                type="password" 
                                name="password" 
                                placeholder="Enter your password" 
                                value={this.state.password} onChange={this.handleChange} />
                            </div>
						</div>
						<div className="text-center mt-2">
                            <button type="submit" className="btn btn-lg btn-primary">Sign In</button>
						</div>
                        <Link to="/register" style={{ marginLeft: '42%', display: 'block', marginTop: '15px' }}>Register</Link>
					</form>
				</div>  
            </div>
        );
    }
}

export default Login;