import React, { useEffect, useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import { request } from '../../axios_helper';

const UpdateUser = () => {
  const [user, setUser] = useState({});
  const { id } = useParams();

  useEffect(() => {
    request("GET", `/api/user/${id}`)
      .then(response => {
        setUser(response.data);
      })
      .catch(error => {
        console.error("Lỗi khi lấy thông tin user:", error);
      });
  }, [id]);

  // const handleChange = (event) => {
  //   const { name, value } = event.target;
  //   setUser((prevUser) => ({
  //     ...prevUser,
  //     [name]: value,
  //   }));
  // };

  const handleSubmit = (event) => {
    event.preventDefault();
    // Gọi API hoặc thực hiện các bước cần thiết để cập nhật user
    // request("POST", `/api/user/update/${id}`, user)
    //   .then(response => {
    //     // Xử lý kết quả cập nhật thành công
    //   })
    //   .catch(error => {
    //     console.error("Lỗi khi cập nhật user:", error);
    //   });
  };

  return (
    <div className="main-login main-center">
      <form onSubmit={handleSubmit} className='form-horizontal'>
        <div className="form-group">
          <label className='cols-sm-2 control-label'>UserName</label>
          <div className='cols-sm-10'>
            <span className="input-group-addon"></span>
            <input
              style={{ fontSize: '15px' }}
              className="form-control"
              type="text"
              name="username"
              placeholder="Enter your username..."
              // value={user.userName || ''}
              // onChange={handleChange}
              
            />
          </div>
        </div>

        <button type="submit" className="btn btn-primary">Update User</button>
      </form>
    </div>
  );
};

export default UpdateUser;
