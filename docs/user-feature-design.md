# Users Feature Design

## Feature Summary
This feature adds user accounts to the Orders app. It covers:
- **Registration:** a new visitor creates an account.
- **Login / logout:** a registered user signs in and out.
- **Admin user management:** an admin can view, edit, and delete users.

Orders are not linked to users in this version. Existing Orders pages keep working as before.

## User Roles
- **Regular user:** can register, log in, log out, and use the Orders pages.
- **Admin:** everything a regular user can do, plus access to the user administration pages.

## High-Level User Flows
- **New user:** Register -> Login -> Use the app
- **Admin:** Login -> View users -> Edit a user, or Delete a user (with a confirmation page)

## Problem This Solves
Right now anyone can use the app. Accounts and roles let the app know who is using it and limit user management to admins.

## Error and Feedback Messages
- Registration: username already taken, passwords do not match
- Login: invalid username or password
- Admin actions: confirmation after edit or delete