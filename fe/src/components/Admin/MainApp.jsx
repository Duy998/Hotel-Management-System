import styles from './MainApp.module.css'; // Import your CSS file
import React, { useState } from 'react';
import FormA from '../User/Users';
import FormB from '../Hotel/ListHotel';
import AddUser from '../User/AddUser';
import AddHotel from '../Hotel/AddHotel'
const MainApp = () => {


    const [showFormA, setShowFormA] = useState(true);
    const [showFormB, setShowFormB] = useState(false);
    const [showFormC, setShowFormC] = useState(false);
    const [showFormD, setShowFormD] = useState(false);
    const [breadcrumbText, setBreadcrumbText] = useState('');

    const handleButtonClick = (formType) => {
      if (formType === 'A') {
        setShowFormA(true);
        setShowFormB(false);
        setShowFormC(false);
        setShowFormD(false);
        setBreadcrumbText('Users');
      } else if (formType === 'B') {
        setShowFormA(false);
        setShowFormB(true);
        setShowFormC(false);
        setShowFormD(false);
        setBreadcrumbText('Hotels');
      } else if (formType === 'C') {
        setShowFormA(false);
        setShowFormB(false);
        setShowFormC(true);
        setShowFormD(false);
        setBreadcrumbText('Users');
      } else if (formType === 'D') {
        setShowFormA(false);
        setShowFormB(false);
        setShowFormC(false);
        setShowFormD(true);
        setBreadcrumbText('Hotels');
      } 
    };

    const handleAddUserClick = (formType) => {
        {showFormA && <AddUser />}
        // {showFormA && <FormA />}
      };
    
    const handleAddHotelClick = () => {
        handleButtonClick('B'); // Khi click vào nút "Add New Hotel", hiển thị form B
      };

    return (
        <div>
            <aside className={ `${styles.app_sidebar}` }>
                <div className={ `${styles.app_sidebar__user}` }>
                    <div>
                        <p className="app-sidebar__user-name"><b>Hotel Admin</b></p>
                        <p className="app-sidebar__user-designation">Welcome to your comeback</p>
                    </div>  
                </div>
                <ul className={ `${styles.app_menu}` }>
                <li>
                    <a className={ `${styles.app_menu__item }` } href="#" onClick={() => handleButtonClick('A')}>
                        <i className={ `${styles.app_menu__icon } bx bx-id-card `}></i>
                        <span className={ `${styles.app_menu__label }` }>List User</span>
                        
                    </a>
                </li>
                <li>
                    <a className={ `${styles.app_menu__item }` } href="#" onClick={() => handleButtonClick('B')}>
                        <i className={ `${styles.app_menu__icon } bx bx-id-card `} ></i>
                        <span className={ `${styles.app_menu__label } ` }>List Hotel</span>
                        
                    </a>
                </li>
                </ul>
            </aside>

            <main className={ `${styles.app_content } ` } >
                <div className={ `${styles.app_title } ` } >
                    <ul className={ `${styles.app_breadcrumb } breadcrumb ` } >
                        <li className={ `${styles.breadcrumb_item } ` } > List {breadcrumbText}</li>
                    </ul>
                </div>

                <div className="row">
                    <div className="col-md-12">
                        <div className="tile">
                        <div className="tile-body">
                            <div className="row element-button">
                            <div className="col-sm-2">
                                {showFormA && (
                                <button className="btn btn-add btn-sm" onClick={() => handleButtonClick('C')} title="Thêm">
                                    <i className="fas fa-plus"></i> Add New User
                                </button>
                                )}
                                {showFormB && (
                                <button className="btn btn-add btn-sm" onClick={() => handleButtonClick('D')} title="Thêm">
                                    <i className="fas fa-plus"></i> Add New Hotel
                                </button>
                                )}
                            </div>
                            </div>
                        </div>
                        </div>
                    </div>
                </div>
                {showFormA && <FormA />}
                {showFormB && <FormB />}
                {showFormC && <AddUser />}
                {showFormD && <AddHotel />}

            </main>
        </div>



    
    );
    }

export default MainApp;
