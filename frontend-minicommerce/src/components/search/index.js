import React from "react";
import classes from "./styles.module.css"
const Search = (props) => {
    const { action, id } = props;
    return (
        <div>
            <input onChange={action} id="search" placeholder="Search your item">
            </input>
        </div>
    );
};
export default Search;