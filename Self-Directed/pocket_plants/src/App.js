import React, { useState, useEffect } from 'react';
import axios from 'axios';

const url = `https://perenual.com/api/species-list?key=sk-g7ki65b7b9c3666f13945`

function App() {
    const [data, setData] = useState([]);

    const fetchData =  async () => {
        try {
            const response = await axios.get(url);
            setData(response.data.data);
        } catch (error) {
            console.error(error);
        }
    }

    useEffect(() => {
        fetchData();
    }, []);

    return (
        <div>
            <h1>Species List</h1>
            <ul>
                {data && data.map((item, index) => (
                    <li key={index}>{item.common_name}<img src={item.default_image} alt=''></img></li>
                ))}
            </ul>
        </div>
    );
}

export default App;
