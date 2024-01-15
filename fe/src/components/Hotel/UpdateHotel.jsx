import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { request } from '../../axios_helper';
import { Navigate } from "react-router-dom";

const UpdateHotel = () => {
  const { id, role } = useParams();
  const [registrationSuccess, setRegistrationSuccess] = useState(false);
  const [hotel, setHotel] = useState({
    address: '',
    description: '',
    imageUrl: '',
    name: '',
    rooms: '',
  });

  useEffect(() => {
    request("GET", `/api/hotels/${id}`)
      .then(response => {
        setHotel(response.data.data);
        console.log(response.data.data)
      })
      .catch(error => {
        console.error("Lỗi khi lấy thông tin user:", error);
      });
  }, [id]);

  const handleChange = (event) => {
    const { name, value } = event.target;
    setHotel((prevUser) => ({
      ...prevUser,
      [name]: value,
    }));
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    // Gọi API hoặc thực hiện các bước cần thiết để cập nhật user
    request("PUT", `/api/hotels/${id}`, hotel)
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
    // if(role= "customer"){
    //   return <Navigate to="/customer "/>;
    // }
    return <Navigate to={`/admin`} />;

  }
  return (
    
    <div className="main-login main-center">
      <form onSubmit={handleSubmit} className='form-horizontal'>
        <div className="form-group">
          <label className='cols-sm-2 control-label'>address</label>
          <div className='cols-sm-10'>
            <input
              className="form-control"
              type="text"
              name="address"
              id="address" 
              placeholder="Enter your phone..."
              value={hotel.address || ''}
              onChange={handleChange}
            />
          </div>
        </div>
        <div className="form-group">
          <label className='cols-sm-2 control-label'>description</label>
          <div className='cols-sm-10'>
            <input
              className="form-control"
              type="text"
              name="description"
              id="description"
              placeholder="Enter your description..."
              value={hotel.description || ''}
              onChange={handleChange}
            />
          </div>
        </div>

        <div className="form-group">
          <label className='cols-sm-2 control-label'>imageUrl</label>
          <div className='cols-sm-10'>
            <input
              className="form-control"
              type="imageUrl"
              name="imageUrl"
              id="imageUrl"
              placeholder="Enter your imageUrl..."
              value={hotel.imageUrl || ''}
              onChange={handleChange}
            />
          </div>
        </div>
        <div className="form-group">
          <label className='cols-sm-2 control-label'>name</label>
          <div className='cols-sm-10'>
            <input
              className="form-control"
              type="text"
              name="name"
              id="name"
              placeholder="Enter your phone..."
              value={hotel.name || ''}
              onChange={handleChange}
            />
          </div>
        </div>
        <div className="form-group">
          <label className='cols-sm-2 control-label'>rooms</label>
          <div className='cols-sm-10'>
            <input
              className="form-control"
              type="text"
              name="rooms"
              id="rooms"
              placeholder="Enter your phone..."
              value={hotel.rooms || ''}
              onChange={handleChange}
            />
          </div>
        </div>
        {/* <div className="form-group">
          <label className='cols-sm-2 control-label'>Role</label>
          <div className='cols-sm-10'>
            <select
              className="form-control"
              name="roleCode"
              id="roleCode"
              value={hotel.roleCode || ''}
              onChange={handleChange}
            >
              <option value="">Select Role</option>
              <option value="USER">User</option>
              <option value="ADMIN">Admin</option>
            </select>
          </div>
        </div> */}
        <button type="submit" className="btn btn-primary">Update User</button>
      </form>
    </div>
  );
};

export default UpdateHotel;
