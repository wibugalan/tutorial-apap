import React from "react";
import classes from "./styles.module.css";
const CartItem = (props) => {
    const { id, title, price, description, category, handleEdit, quantity} =
        props;

    const total = price * quantity
    return (
        <div className={classes.item}>
            <h3>{`ID ${id}`}</h3>
            <p>{`Nama Barang: ${title}`}</p>
            <p>{`Harga: ${price}`}</p>
            <p>{`Deskripsi: ${description}`}</p>
            <p>{`Kategori: ${category}`}</p>
            <p>{`stok: ${quantity}`}</p>
            <p className={classes.bold}>{`Total Harga: ${total}`}</p>
        </div>
    );
};
export default CartItem;
