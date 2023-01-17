import { useState } from "react";
import axios from 'axios';

const SendData = (props) => {
    const [apiData, setApiData] = useState({userid:""});
    
    const deleteStd = (event) => {
        event.preventDefault();
        axios.delete(`http://localhost:5213/api/users/${apiData.userid}`);
    }

    const handleChange=(event)=>{
        const {name,value} =event.target
        setApiData({...apiData,[name]:value})
    }

    return (
        <>
            <br/><br/>
            <h4>Enter student's rollno to be deleted.</h4>
            <form method="GET" onSubmit={deleteStd}>
                <input type="text" name="userid" onChange={handleChange} placeholder="UserId"/>
                <input type="Submit" value="Delete"/>
            </form>
        </>
    );

}
export default SendData;