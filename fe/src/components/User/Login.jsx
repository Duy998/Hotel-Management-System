import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import styles from './styles.module.css';

class Login extends Component {

    constructor(props) {
        super(props);
    
        this.state = {
            username: '',
            password: ''
        };
      }


    setParams = (event) => {
        let name = event.target.name
        let value = event.target.value
        this.setState({[name]: value})
    }
    submitLogin = () =>{
        console.log(this.state)
    }  

    render() {
        return (
            <div className={styles.register_form_container}>
                <div className="panel-heading">
                    <div className="panel-title text-center">  
                        <h1 className="h2">LOGIN</h1>
                        <hr />
                    </div>
                </div>  
                <div className="main-login main-center">
					<form>
                        <div className="form-group">
                        <label className='cols-sm-2 control-label'>UserName</label>
                            <div className='cols-sm-10'>
                                <input 
                                style={{ fontSize: '15px' }}
                                className="form-control form-control-lg" 
                                type="text" 
                                name="username" 
                                placeholder="Enter your name" 
                                value={this.state.username} onChange={this.setParams} />
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
                                value={this.state.password} onChange={this.setParams} />
                            </div>
						</div>
						<div className="text-center mt-2">
						    <button type="submit" className="btn btn-lg btn-primary"
                            onClick={this.submitLogin}  >Sign In</button> 
						</div>
                        <Link to="/register" style={{ marginLeft: '42%', display: 'block', marginTop: '15px' }}>Register</Link>
					</form>
				</div>  
            </div>
        );
    }
}

export default Login;