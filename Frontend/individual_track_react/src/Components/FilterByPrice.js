import React from 'react'
import "./FilterByPrice.css"

export function FilterByPrice() {
    return (
        <>
        <h2>Choose price range</h2>
        <select class="form-select" aria-label="Default select example">
        <option selected>less than 100$</option>
        <option value="1">less than 200$</option>
        <option value="2">less than 350$</option>
        <option value="3">more than 350$</option>
        </select>
        </>
    )
}

export default FilterByPrice
