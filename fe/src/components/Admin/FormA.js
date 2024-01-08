// FormA.js
import React from 'react';
import styles from './MainApp.module.css';

const FormA = () => {
  return (
    <table className="table table-hover table-bordered js-copytextarea dataTable no-footer" cellpadding="0"
      cellspacing="0" border="0" id="sampleTable" role="grid" aria-describedby="sampleTable_info">
                    <thead>
                        <tr>
                            <th>FullName</th>
                            <th>UserName</th>
                            <th>PassWord</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Option</th>  
                        </tr>
                    </thead>
                    <tbody>
                        <tr role="row" className="odd">
                            <td ></td>
                            <td>#CD12837</td>
                            <td>Hồ Thị Thanh Ngân</td>
                            <td></td>
                            <td>155-157 Trần Quốc Thảo, Quận 3, Hồ Chí Minh </td>
                            
                            <td className="table-td-center">
                                <button className={ `${styles.trash }  btn btn-primary btn-sm ` } 
                                type="button" title="Xóa" onclick="myFunction(this)"><i class="fas fa-trash-alt"></i>
                                </button>

                                <button className={ `${styles.btn_primary }  btn btn-primary btn-sm ` }
                                type="button" title="Sửa" id="show-emp" data-toggle="modal" data-target="#ModalUP"><i class="fas fa-edit"></i>
                                </button>
                            </td>
                        </tr>    
                    </tbody>
    </table> 
  );
};

export default FormA;
