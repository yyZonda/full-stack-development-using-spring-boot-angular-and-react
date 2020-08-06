import React from "react";
import axios from 'axios'
import {toast} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css'

toast.configure();

class AddPatient extends React.Component{
    handleSubmit(event){
        event.preventDefault();
        const data ={
            firstName:this.firstName,
            lastName:this.lastName,
            age:this.age
        }
        axios.post("http://localhost:8080/clinicalservices/api/patients",data)
            .then(res=>{
                toast("patient Added Successfully!",{autoClose:2000,position:toast.POSITION.BOTTOM_CENTER})
                event.preventDefault(3);
            })
    }
    render() {
        return(<div>
            <h2>Create Patient:</h2>
            <form>
                First Name: <input type="text" name="firstName" onchange={(event=>this.firstName=event.target.value)}/>
                Last Name: <input type="text" name="lastName" onchange={(event=>this.lastName=event.target.value)}/>
                Age: <input type="text" name="age" onchange={(event=>this.age=event.target.value)}/>
                <button onClick={this.handleSubmit.bind(this)}>Confirm</button>
            </form>
        </div>)

    }
}

export default AddPatient;
