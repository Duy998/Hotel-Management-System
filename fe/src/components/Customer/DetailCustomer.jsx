import React, { useState, useEffect } from 'react';
import styles from './Customer.module.css'; // Import the stylesheet
import { useParams } from 'react-router-dom';
import { request } from '../../axios_helper';
import { Navigate } from "react-router-dom";
import { Link } from 'react-router-dom';

const DetailCustomer = () => {

    const { id } = useParams();
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




  return (
    <div className={styles.app_container}>
      <aside className={styles.app_sidebar}>
        <div className={styles.app_sidebar__user}>
          <div>
            <p className={styles.app_sidebar__user_name}><b>Hello {user.fullName}</b></p>
            <p className={styles.app_sidebar__user_designation}>Welcome to {user.fullName} comeback</p>
          </div>
        </div>
        <ul className={styles.app_menu}>
          <li>
            <a className={styles.app_menu__item} href="#">
              <i className={`${styles.app_menu__icon} bx bx-id-card`}></i>
              <span className={styles.app_menu__label}>Information</span>
            </a>
          </li>
          <li>
            <a className={styles.app_menu__item} href="#">
              <i className={`${styles.app_menu__icon} bx bx-id-card`}></i>
              <span className={styles.app_menu__label}>See All Hotel</span>
            </a>
          </li>
        </ul>
      </aside>

      <main className={styles.app_content}>
        <div className="col-lg-8">
          {/* Your main content goes here */}
          <div className="card shadow-sm">
            <div className="card-header bg-transparent text-center">
              {/* <img className="profile_img" src="https://source.unsplash.com/600x300/?student" alt="student dp" /> */}
              <h3>Welcome {user.fullName}</h3>
            </div>
            <div className="card-body">
              <p className="mb-0"><strong className="pr-1">UserName</strong>{user.fullName}</p>
              <p className="mb-0"><strong className="pr-1">NumberPhone</strong>{user.phoneNumber}</p>
              <p className="mb-0"><strong className="pr-1">Email</strong>{user.email}</p>
            </div>
          </div>
        </div>

        {/* <button className={styles.butoon_update_infor} title="Update" tag={Link}  to={"/user/" + user.id}> 
            <i className="fas fa-plus "></i> Update Information
        </button> */}
        <Link to={`/user/${user.id}?role=${user.email}`}>
            <button className={styles.butoon_update_infor} title="Update">
                <i className="fas fa-plus"></i> Update Information
            </button>
        </Link>

      </main>
    </div>
  );
}

export default DetailCustomer;
