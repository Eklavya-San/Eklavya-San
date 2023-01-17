import { useState } from "react";
import axios from 'axios';

const SendData = (props) => {
    const [apiData, setApiData] = useState({username:"",course:"",purchasedate:""});
    
    const savedata = (event) => {
        event.preventDefault();
        axios.post('http://localhost:5213/api/users', apiData);
    }

    const handleChange=(event)=>{
        const {name,value} =event.target
        setApiData({...apiData,[name]:value})

    }

    return (
        <>
            <br/><br/>
            <h4>Add new user</h4>
            <form method="POST" onSubmit={savedata}>
                <input type="text" name="username" onChange={handleChange} placeholder="UserName"/>
                <input type="text" name="course" onChange={handleChange} placeholder="Course"/>
                <input type="text" name="purchasedate" onChange={handleChange} placeholder="PurchaseDate"/>
                <input type="Submit"/>
            </form>
        </>
    );

}
export default SendData;