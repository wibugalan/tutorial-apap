import React from "react";
import Button from "../button";
import classes from "./styles.module.css";
import ItemList from "../../containers/itemlist/index";
const Item = (props) => {
    const { id, title, price, description, category, handleEdit, quantity, handleDelete } =
        props;
    return (
        <div className={classes.item}>
            <h3>{`ID ${id}`}</h3>
            <p>{`Nama Barang: ${title}`}</p>
            <p>{`Harga: ${price}`}</p>
            <p>{`Deskripsi: ${description}`}</p>
            <p>{`Kategori: ${category}`}</p>
            <p>{`stok: ${quantity}`}</p>
            <Button action={handleEdit}>Edit</Button>
        </div>
    );
};
export default Item;
