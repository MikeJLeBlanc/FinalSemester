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
        <div className="container">
          <div className="jumbotron">
            <h1 className="display-4">Posts from our API call</h1>
          </div>
          {data?.map((post) => (
            <div className="card" key={post.id}>
              <div className="card-header">
                ID #{post.id} {post.title}
              </div>
              <div className="card-body">
                <img src={post.thumbnailUrl}></img>
              </div>
            </div>
          ))}
        </div>
      );
          }

export default App;