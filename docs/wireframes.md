# Wireframes

Text wireframes describe layout and content, not styling.

## Navigation (all pages)
- App title / Orders link
- Logged out: Login link, Register link
- Logged in: Logout button
- Admin only: "Manage Users" link (/admin/users)

## login.html
- Page title: Login
- Username input
- Password input
- Login button
- Error message area (invalid credentials)
- Link to Register

## register.html
- Page title: Register
- Username input
- Password input
- Confirm password input
- Register button
- Error message area (username taken, passwords do not match)
- Link to Login

## userAdmin.html
- Page title: User Administration
- Table of users: username, role, enabled
- Edit link and Delete link on each row
- Message area (confirmation after edit or delete)

## editUser.html
- Page title: Edit User
- Hidden id field
- Username input
- Role selection (USER / ADMIN)
- Enabled checkbox
- Save button, Cancel link
- Error message area

## confirmDeleteUser.html
- Page title: Confirm Delete
- Text showing which user will be deleted (username)
- Hidden id field
- Delete button, Cancel link