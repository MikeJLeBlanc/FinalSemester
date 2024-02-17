import { getToken } from './users-service';
import axios from 'axios';

export default async function sendRequest(url, method = 'GET', data = null) {
    const options = {};}