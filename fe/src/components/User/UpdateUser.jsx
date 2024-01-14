import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { request } from '../../axios_helper';
import { Navigate } from "react-router-dom";

const UpdateUser = () => {
  const { id } = useParams();
  const [registrationSuccess, setRegistrationSuccess] = useState(false);
  const [user, setUser] = useState({
    fullName: '',
    username: '',
    email: '',
    phoneNumber: '',
  });

  useEffect(() => {
    request("GET", `/api/user/${id}`)
      .then(response => {
        setUser(response.data);
        console.log(response.data)
      })
      .catch(error => {
        console.error("Lỗi khi lấy thông tin user:", error);
      });
  }, [id]);

  const handleChange = (event) => {
    const { name, value } = event.target;
    setUser((prevUser) => ({
      ...prevUser,
      [name]: value,
    }));
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    // Gọi API hoặc thực hiện các bước cần thiết để cập nhật user
    request("PUT", `/api/user/${id}`, user)
      .then(response => {
        setRegistrationSuccess(true);
        alert("Update successful");
      })
      .catch(error => {
        console.error("Lỗi khi cập nhật user:", error);
      });
  };
  if (registrationSuccess) {
    // You can conditionally render or redirect to another page after successful update
    return <Navigate to="/admin" />;
  }
  return (
    
    <div className="main-login main-center">
      <form onSubmit={handleSubmit} className='form-horizontal'>
        <div className="form-group">
          <label className='cols-sm-2 control-label'>FullName</label>
          <div className='cols-sm-10'>
            <input
              className="form-control"
              type="text"
              name="fullName"
              id="fullName" 
              placeholder="Enter your phone..."
              value={user.fullName || ''}
              onChange={handleChange}
            />
          </div>
        </div>
        <div className="form-group">
          <label className='cols-sm-2 control-label'>Username</label>
          <div className='cols-sm-10'>
            <input
              className="form-control"
              type="text"
              name="username"
              id="username"
              placeholder="Enter your username..."
              value={user.username || ''}
              onChange={handleChange}
            />
          </div>
        </div>

        <div className="form-group">
          <label className='cols-sm-2 control-label'>Email</label>
          <div className='cols-sm-10'>
            <input
              className="form-control"
              type="email"
              name="email"
              id="email"
              placeholder="Enter your email..."
              value={user.email || ''}
              onChange={handleChange}
            />
          </div>
        </div>

        <div className="form-group">
          <label className='cols-sm-2 control-label'>Phone</label>
          <div className='cols-sm-10'>
            <input
              className="form-control"
              type="text"
              name="phoneNumber"
              id="phoneNumber"
              placeholder="Enter your phone..."
              value={user.phoneNumber || ''}
              onChange={handleChange}
            />
          </div>
        </div>
        <div className="form-group">
          <label className='cols-sm-2 control-label'>Role</label>
          <div className='cols-sm-10'>
            <select
              className="form-control"
              name="roleCode"
              id="roleCode"
              value={user.roleCode || ''}
              onChange={handleChange}
            >
              <option value="">Select Role</option>
              <option value="USER">User</option>
              <option value="ADMIN">Admin</option>
            </select>
          </div>
        </div>
        <button type="submit" className="btn btn-primary">Update User</button>
      </form>
    </div>
  );
};

export default UpdateUser;
