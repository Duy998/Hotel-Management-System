import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { request } from '../../axios_helper';

const UpdateUser = () => {
  const { id } = useParams();
  const [user, setUser] = useState({
    userName: '',
    email: '',
    phone: '',
  });

  useEffect(() => {
    request("GET", `/api/user/${id}`)
      .then(response => {
        setUser(response.data);
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
        // Xử lý kết quả cập nhật thành công
        console.log('User updated successfully');
      })
      .catch(error => {
        console.error("Lỗi khi cập nhật user:", error);
      });
  };

  return (
    <div className="main-login main-center">
      <form onSubmit={handleSubmit} className='form-horizontal'>
        <div className="form-group">
          <label className='cols-sm-2 control-label'>Username</label>
          <div className='cols-sm-10'>
            <input
              className="form-control"
              type="text"
              name="username"
              placeholder="Enter your username..."
              value={user.userName || ''}
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
              name="phone"
              placeholder="Enter your phone..."
              value={user.phone || ''}
              onChange={handleChange}
            />
          </div>
        </div>

        <button type="submit" className="btn btn-primary">Update User</button>
      </form>
    </div>
  );
};

export default UpdateUser;
