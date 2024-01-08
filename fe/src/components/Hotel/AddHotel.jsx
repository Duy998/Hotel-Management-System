import React, { useEffect, useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import { request } from '../../axios_helper';
// import styles from './styles.module.css';

const AddUser = () => {
  const [users, setUsers] = useState([]);
  const { id } = useParams();

  useEffect(() => {
    // Gọi API hoặc thực hiện các hành động dựa trên user.id
    console.log(id)
    request("GET", `/api/user/${id}`)
      .then(response => {
        setUsers(response.data);
        console.log(response.data);
        // users = this.state.users;
        // setUsers(users);
      })
      .catch(error => {
        console.error("Lỗi khi lấy thông tin user:", error);
      });
  }, [id]);



  return (
    <div className="container">
        <h1>Add hotel</h1>

        <div className="row">
          <div className="col-md-3">
            {/* Phần 3/7 của giao diện */}
            <div>
              <p>ID: {users.id}</p>
              {/* Hiển thị các thông tin khác */}
            </div>
          </div>

          <div className="col-md-9">
            {/* Phần 7/7 của giao diện */}
            <div>
              <p>Tên: {users.id}</p>
              <p>Email: {users.id}</p>
              {/* Hiển thị các thông tin khác */}
            </div>
          </div>
        </div>
      </div>

    // <div className="container">
    //   <div>
    //             <div className={styles.register_form_container}>
    //                 <div className="panel-heading">
    //                     <div className="panel-title text-center">  
    //                         <h1 className="h2">{users.id}</h1>
    //                         <hr />
    //                     </div>



    //                 </div> 
                    
    //             </div>
    //     </div>
    // </div>
  );
};

export default AddUser;
