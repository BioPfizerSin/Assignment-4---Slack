import { Component } from "react";
import axios from "axios";

class SendMessageComponent extends Component{

    constructor(props){
        super(props);
        this.state={text:"",userName:"biopfizer"}
        }

   
    handleSubmit = event => {
            event.preventDefault();
        
            const text = {
              text: this.state.text
            };
            console.log(text)
        
            axios.post('http://localhost:8080/messages/'+this.state.userName,text )
              .then(res => {
                console.log(res);
                console.log(res.data);
              })
          }


    
    sendMessageHandler=(event)=>{
            console.log("On Change Handler - Value is "+event.target.value);
            var text_value=event.target.value;
            this.setState({text:text_value});
    }


    render(){
        return(
            <div>
                    <h1> Send Message </h1>
                    <form onSubmit={this.handleSubmit}>
                        <label>Enter Your Message</label><br></br>
                        <textarea value={this.state.text} onChange={this.sendMessageHandler}/><br></br>
                        <input type="submit" value="Send Message"/>
                    </form>
            </div>
        );

        }

}

export default SendMessageComponent;