// UserService.js
import axios from 'axios';

const USER_API_BASE_URL = "http://localhost:8085/users";

class UserService {
  getAllUsers() {
    return axios.get(USER_API_BASE_URL);
  }
}

export default new UserService();
