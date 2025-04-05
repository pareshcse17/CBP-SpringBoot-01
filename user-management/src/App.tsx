import React from 'react';
import UserForm from '../../react/user-manage-aws/src/components/UserForm';
import UserList from '../../react/user-manage-aws/src/components/UserList';

const App: React.FC = () => {
    return (
        <div>
            <h1>User Management</h1>
            <UserForm />
            <UserList />
        </div>
    );
};

export default App;
