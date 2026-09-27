# File Map (Frontend/Backend Contract)

| Method / URL | Template | Required contract |
|---|---|---|
| GET /login | login.html | Form submits `username` and `password` to POST /login |
| GET /register | register.html | Form submits `username`, `password`, `confirmPassword` to POST /register |
| POST /register | (redirects to /login) | Backend validates and saves user; on error, returns to register.html with an error message |
| GET /admin/users | userAdmin.html | Model attribute `users` (list of users) |
| GET /admin/users/edit/{id} | editUser.html | Model attribute `user` (username, role, enabled) |
| POST /admin/users/edit | (redirects to /admin/users) | Hidden form field `id`, plus `username`, `role`, `enabled` |
| GET /admin/users/delete/{id} | confirmDeleteUser.html | Model attribute `user` |
| POST /admin/users/delete | (redirects to /admin/users) | Hidden form field `id` |

## Notes
- `confirmPassword` is only checked at registration and is not stored in UserEntity.
- Error messages are shown in a message area on each page.
- If a route, field name, or model attribute changes, update this file first.