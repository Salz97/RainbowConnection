import React from 'react'
function Table(props) {
    return (
       

<tr>
            <td className="id">{props.id}</td>
            <td className="firstname"> {props.firstName}</td>
            <td className='lastname'>{props.lastName}</td>
            <td className="colour">{props.colour}</td>
            <td className="followerCount">{props.followerCount}</td>
            <td className="followers">{props.followers}</td>
            
        </tr>
          
    )
}

export default Table