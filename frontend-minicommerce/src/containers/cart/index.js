import React, { Component } from "react";
import Item from "../../components/cartItem/index";
import classes from "./styles.module.css";
import Button from "../../components/button";
import APIConfig from "../../api/APIConfig"
import Fab from '@mui/material/Fab';
import ViewStreamIcon from '@mui/icons-material/ViewStream';
import { Link } from "react-router-dom";

class Cart extends Component {
    constructor(props) {
        super(props);
        this.state = {
            cartItems: [],
        };
        this.handleCheckout = this.handleCheckout.bind(this);
        this.loadData = this.loadData.bind(this);
    }

    componentDidMount() {
        this.loadDataCart();
    }

    async loadDataCart() {
        try {
            const { data } = await APIConfig.get("/cart");
            this.setState({ cartItems: data.result });
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    async handleCheckout() {
        try {
            await APIConfig.get("/cart/checkout");
            this.setState({
                cartItems: []
            })
            this.loadData();
            alert("Checkout berhasil dilakukan")
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    async loadData() {
        try {
            const { data } = await APIConfig.get("/cart");
            this.setState({ items: data.result });
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    render() {
        return (
            <div className={classes.itemList}>
                <h1 className={classes.title}>Cart</h1>
                <Link to='/list-item'>
                    <div style={{ position: 'fixed', top: 25, right: 25 }}>
                        <Fab variant="extended">
                            <ViewStreamIcon />
                        </Fab>
                    </div>
                </Link>
                <Button action={this.handleCheckout}>Checkout</Button>
                <div>
                    {this.state.cartItems.map((item) => (
                        <Item
                            key={item.item.id}
                            id={item.item.id}
                            title={item.item.title}
                            price={item.item.price}
                            description={item.item.description}
                            category={item.item.category}
                            quantity={item.quantity}
                        />
                    ))}
                </div>
            </div>
        )
    }
}
export default Cart;