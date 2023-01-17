import { useEffect, useState } from "react";
import axios from 'axios';

const DisplayData = (props) => {
    const [apiData, setApiData] = useState([]);
    useEffect(
        () => {
            axios.get('http://localhost:5213/api/users')
                .then(response => { setApiData(response.data) ;});
        }
    )

    

    var tablerows = apiData.map(obj => {
        return (
            <tr>
                <td>{obj.userid}</td>
                <td>{obj.username}</td>
                <td>{obj.course}</td>
                <td>{obj.purchasedate}</td>
            </tr>
        );
    });

    return (
        <>
            <br/><br/>
            <table id="studentsTable">
                <tr>
                    <td>UserId</td>
                    <td>Username</td>
                    <td>Course</td>
                    <td>PurchaseDate</td>
                </tr>
                {tablerows}
            </table>
        </>
    );

}
export default DisplayData;