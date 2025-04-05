import React, { useEffect, useState } from 'react';
import { getAllUsers } from '../services/api';
import styles from './UserList.module.css';

const UserList: React.FC = () => {
    const [users, setUsers] = useState<{ id: number; name: string; email: string }[]>([]);

    useEffect(() => {
        const fetchUsers = async () => {
            try {
                const response = await getAllUsers();
                setUsers(response.data);
            } catch (error) {
                alert('Error fetching users');
            }
        };
        fetchUsers();
    }, []);

    return (
        <div className={styles.container}>
            <h2 className={styles.title}>User List</h2>
            <ul className={styles.userList}>
                {users.map((user) => (
                    <li key={user.id} className={styles.userItem}>
                        {user.name} - {user.email}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default UserList;
