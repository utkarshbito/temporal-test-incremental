# Custom Instructions - testing-bito

## Repository Role

`testing-bito` is the primary backend service repository in this test workspace. It should be treated as a small Spring-style Java service centered around the `User` domain.

## Core Architecture

- `Rename.java` is the main REST controller entry point.
- `UserService.java` is the service layer.
- `UserRepository.java` is the persistence layer.
- `User.java` is the core entity model for user data.

This repository follows a layered structure:

- controller -> service -> repository -> entity

## Important Internal Relationships

- `UserService` depends on `UserRepository`.
- `UserRepository` manages `User` entities.
- `UserService` owns CRUD-style user operations:
  - `getAllUsers`
  - `getUserById`
  - `createUser`
  - `updateUser`
  - `deleteUser`

## API Ownership

The following endpoints belong to this repository:

- `GET /api/hello`
- `GET /api/divide`
- `GET /api/crash`

`Rename.java` should be interpreted as the main API/controller file even though the repository intentionally contains buggy sample code.

## Domain Notes

- This repository owns the `User` domain in the workspace.
- The `User` model contains:
  - `id`
  - `name`
  - `email`

## Cross-Repo Relationship

`testing-bito` shares the same conceptual `User` domain with `temporal-test-incremental`.

- `testing-bito` is the active service/API repository.
- `temporal-test-incremental` is a companion repository used for schema continuity and incremental indexing validation.

The shared `User` entity between the two repositories should be treated as a meaningful clustering and cross-repo relationship signal.
