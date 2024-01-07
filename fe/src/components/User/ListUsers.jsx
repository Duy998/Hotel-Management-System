import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { Navigate } from "react-router-dom";
import styles from './styles.module.css';
import { request } from '../../axios_helper';

class ListUsers extends Component {

<div class="container">
    <h1>Danh sách Nhà cung cấp</h1>
    <table class="table table-borderd">
        <thead>
            <tr>
                <th>STT</th>
                <th>Mã nhà Cung cấp</th>
                <th>Tên nhà Cung cấp</th>
                <th>Ghi chú</th>
                <th>Ảnh đại diện</th>
                <th>Ngày tạo mới</th>
                <th>Ngày cập nhật</th>
                <th>###</th>
            </tr>
        </thead>
        <tbody>

                <tr>
                    <td>"a"</td>
                    <td>"a"</td>
                    <td>"a"</td>
                    <td>"a"</td>
                    <td>"a"</td>
                    <td>
                        <a href="" id="btnUpdate" class="btn btn-primary">
                            <i class="fas fa-edit"></i>
                        </a>

                        <a href="" id="btnDelete" class="btn btn-danger">
                            <i class="fas fa-trash-alt"></i>
                        </a>
                    </td>
                </tr>
        </tbody>
    </table>
</div>
}

export default ListUsers;
