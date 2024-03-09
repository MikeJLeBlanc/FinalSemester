

function APICall () {
    const [data, setData] = useState(null);

    function handleClick() {
      useEffect(() => {
      fetch('https://perenual.com/api/species-list?key=sk-g7ki65b7b9c3666f13945')
      .then(response => response.json())
      .then(data => setData(data.data))
      .catch(error => console.log(error));
      }, []);
    }
  
    return (
      <div>
        <button onClick={handleClick}>Get Data</button>
        {data ? <div>{JSON.stringify(data)}</div> : <div>Loading...</div>}
      </div>
    );
}

export default APICall;