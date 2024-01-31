import React, { useState, useEffect } from 'react';
import axios from 'axios';

function App() {
    const [data, setData] = useState(null);

    useEffect(() => {
        async function fetchData() {
            try {
                const response = await axios.get(`https://perenual.com/api/species-list?key=sk-g7ki65b7b9c3666f13945`);
                setData(response.data);
            } catch (error) {
                console.error("Error fetching data:", error);
            }
        }
        
        fetchData();
    }, []);

    return (
      <div>
        <h1>API Data</h1>
        <pre>{JSON.stringify(data, null, 2)}</pre>
      </div>
    );
}

export default App;