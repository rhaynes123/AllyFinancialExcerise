import React, { Component } from 'react';
import ItemDataService from './ItemdataService';
import {Formik, Form, Field, ErrorMessage } from 'formik';
import axios from 'axios'
class ItemComponent extends Component{
    //this.bidItemClicked = this.bidItemClicked.bind(this)
    constructor(props){
        super(props)

        this.state ={
            id: this.props.match.params.id,
            description: '',
            reservePrice: 0,
            dateAdded:''
        }
        console.log('state id '+this.state.id);
        console.log('state props '+this.props);
        //this.bidItemClicked = this.bidItemClicked.bind(this)
        this.onSubmit = this.onSubmit.bind(this)
        this.validate = this.validate.bind(this)
    }

     componentDidMount(){
         /*
        console.log(this.state.id);:
        fetch('/api/v1/item/' + this.state.id)
        .then(response => response.json())
        .then(data => this.setState({id: data, isLoading: false}));
        console.log(this.state.id);*/
        
        ItemDataService.retrieveItem(1)//hard codes 1 as a test
        .then(response => this.setState({
            id: response.data.id,
            description: response.data.description,
            reservePrice: response.data.reservePrice,
            dateAdded: response.data.dateAdded
        })) 
        
    }
    validate(values) {
        let errors = {}
        if (!values.description) {
            errors.description = 'Enter a Description'
        } else if (values.description.length < 5) {
            errors.description = 'Enter atleast 5 Characters in Description'
        }

        return errors

    }
    onSubmit(values) {
        /*
        ItemDataService.updateItem(1)
        .then(() => this.props.history.push('/item/'+1))
        */
        let Item = {
            id: this.state.id,
            description: values.description,
            reservePrice: values.reservePrice,
            dateAdded: values.dateAdded
            
            //targetDate: values.targetDate
        } 
        console.log(Item);
        
//         axios.put(`http://localhost:8080/api/v1/item/`+Item.id,Item);
        //const {Item} = this.state;

         fetch('/api/v1/item/'+Item.id, { //Likely will need to re-add the api uri
          method: (Item.id) ? 'PUT' : 'POST',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(Item),
        });
        this.props.history.push('item'+Item.id); 

        console.log(values); 
    } 
    render(){
        let {dateAdded,reservePrice, description, id } = this.state
        //const title = <h2>{this.state.id ? 'Edit Group' : 'Add Group'}</h2>;

        return(
            <div>
                <h3>Bidding Item</h3>
                <div className="container">
                    <Formik
                        initialValues={{ id, description , reservePrice,dateAdded}}
                        onSubmit={this.onSubmit}
                        validateOnChange={false}
                        validateOnBlur={false}
                        validate={this.validate}
                        enableReinitialize={true}
                    >
                        {
                            (props) => (
                                <Form>
                                    <ErrorMessage name="description" component="div"
                                        className="alert alert-warning" />
                                    <fieldset className="form-group">
                                        <label>Id</label>
                                        <Field className="form-control" type="text" name="id" disabled />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Description</label>
                                        <Field className="form-control" type="text" name="description" disabled/>
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Reserve Price</label>
                                        <Field className="form-control" type="text" name="reservePrice" />
                                    </fieldset>
                                    <button className="btn btn-success" type="submit">Save</button>
                                </Form>
                            )
                        }
                    </Formik>

                </div>
            </div>
        ) 
    }
}
export default ItemComponent
