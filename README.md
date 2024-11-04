# EchoBeat API Documentation

## Table of Contents
- [Album Controller](#album-controller)
- [Artist Controller](#artist-controller)
- [Chart Controller](#chart-controller)
- [Created Album Controller](#created-album-controller)
- [Follower Controller](#follower-controller)
- [Liked Albums Controller](#liked-albums-controller)
- [Liked Playlists Controller](#liked-playlists-controller)
- [Liked Podcasts Controller](#liked-podcasts-controller)
- [Liked Songs Controller](#liked-songs-controller)
- [Perks Controller](#perks-controller)
- [Playlist Controller](#playlist-controller)
- [Playlist Track Controller](#playlist-track-controller)
- [Podcast Controller](#podcast-controller)
- [Podcast Creator Controller](#podcast-creator-controller)
- [Ranking Controller](#ranking-controller)
- [SocialMediaController](#socialmediacontroller)
- [SubscriptionController](#subscriptioncontroller)
- [TrackController](#trackcontroller)
- [TrackCreatorController](#trackcreatorcontroller)
- [UserController](#usercontroller)

## Album Controller

### Get Album by ID
- **Endpoint**: `GET /api/albums/{id}`
- **Description**: Retrieves an album by its ID.
- **Parameters**:
  - `id`: The ID of the album.
- **Response**:
  - `200 OK`: The album object.
  - `404 Not Found`: If the album is not found.

### Create Album
- **Endpoint**: `POST /api/albums`
- **Description**: Creates a new album.
- **Request Body**:
  - `album_id`: The ID of the album.
  - `title`: The title of the album.
  - `genre`: The genre of the album.
  - `release_date`: The release date of the album.
- **Response**:
  - `201 Created`: A success message indicating the album was created.
  - `500 Internal Server Error`: If there was an error creating the album.

### Delete Album
- **Endpoint**: `DELETE /api/albums/{id}`
- **Description**: Deletes an album by its ID.
- **Parameters**:
  - `id`: The ID of the album.
- **Response**:
  - `200 OK`: A success message indicating the album was deleted.
  - `500 Internal Server Error`: If there was an error deleting the album.

## Artist Controller

### Get Artist by ID
- **Endpoint**: `GET /api/artists/{id}`
- **Description**: Retrieves an artist by their ID.
- **Parameters**:
  - `id`: The ID of the artist.
- **Response**:
  - `200 OK`: The artist object.
  - `404 Not Found`: If the artist is not found.

### Create Artist
- **Endpoint**: `POST /api/artists`
- **Description**: Creates a new artist.
- **Request Body**:
  - `first_name`: The first name of the artist.
  - `last_name`: The last name of the artist.
  - `password`: The password of the artist.
  - `global_rank`: The global rank of the artist.
  - `country`: The country of the artist.
  - `about`: The biography of the artist.
  - `follower_count`: The number of followers of the artist.
- **Response**:
  - `201 Created`: A success message indicating the artist was created.
  - `500 Internal Server Error`: If there was an error creating the artist.

### Update Artist
- **Endpoint**: `POST /api/artists/{id}`
- **Description**: Updates an existing artist.
- **Parameters**:
  - `id`: The ID of the artist.
- **Request Body**:
  - `first_name`: The first name of the artist.
  - `last_name`: The last name of the artist.
  - `password`: The password of the artist.
  - `global_rank`: The global rank of the artist.
  - `country`: The country of the artist.
  - `about`: The biography of the artist.
  - `follower_count`: The number of followers of the artist.
- **Response**:
  - `200 OK`: A success message indicating the artist was updated.
  - `404 Not Found`: If the artist is not found.

### Delete Artist
- **Endpoint**: `DELETE /api/artists/{id}`
- **Description**: Deletes an artist by their ID.
- **Parameters**:
  - `id`: The ID of the artist.
- **Response**:
  - `200 OK`: A success message indicating the artist was deleted.
  - `404 Not Found`: If the artist is not found.

### Get Tracks by Artist ID
- **Endpoint**: `GET /api/artisttracks/{id}`
- **Description**: Retrieves the tracks associated with an artist by their ID.
- **Parameters**:
  - `id`: The ID of the artist.
- **Response**:
  - `200 OK`: A list of tracks associated with the artist.
  - `204 No Content`: If there are no tracks associated with the artist.

### Get Albums by Artist ID
- **Endpoint**: `GET /api/artistalbums/{id}`
- **Description**: Retrieves the albums associated with an artist by their ID.
- **Parameters**:
  - `id`: The ID of the artist.
- **Response**:
  - `200 OK`: A list of albums associated with the artist.
  - `204 No Content`: If there are no albums associated with the artist.

## Chart Controller

### Get Chart by ID
- **Endpoint**: `GET /api/charts/{id}`
- **Description**: Retrieves a chart by its ID.
- **Parameters**:
  - `id`: The ID of the chart.
- **Response**:
  - `200 OK`: The chart object.
  - `404 Not Found`: If the chart is not found.

### Get All Charts
- **Endpoint**: `GET /api/charts`
- **Description**: Retrieves all the charts.
- **Response**:
  - `200 OK`: A list of all the charts.
  - `204 No Content`: If there are no charts.

### Create Chart
- **Endpoint**: `POST /api/charts`
- **Description**: Creates a new chart.
- **Request Body**:
  - `chart_type`: The type of the chart.
  - `chart_id`: The ID of the chart.
- **Response**:
  - `201 Created`: A success message indicating the chart was created.
  - `500 Internal Server Error`: If there was an error creating the chart.

### Update Chart
- **Endpoint**: `POST /api/charts/{id}`
- **Description**: Updates an existing chart.
- **Parameters**:
  - `id`: The ID of the chart.
- **Request Body**:
  - `chart_type`: The new type of the chart.
  - `chart_id`: The new ID of the chart.
- **Response**:
  - `200 OK`: A success message indicating the chart was updated.
  - `404 Not Found`: If the chart is not found.

### Delete Chart
- **Endpoint**: `DELETE /api/charts/{id}`
- **Description**: Deletes a chart by its ID.
- **Parameters**:
  - `id`: The ID of the chart.
- **Response**:
  - `200 OK`: A success message indicating the chart was deleted.
  - `404 Not Found`: If the chart is not found.

## Created Album Controller

### Add Created Album
- **Endpoint**: `POST /api/created-album`
- **Description**: Adds a created album.
- **Request Body**:
  - The `CreatedAlbum` object.
- **Response**:
  - `201 Created`: A success message indicating the album was created.
  - `500 Internal Server Error`: If there was an error creating the album.

### Remove Created Album
- **Endpoint**: `DELETE /api/created-album/{album_id}/{artist_id}`
- **Description**: Removes a created album.
- **Parameters**:
  - `album_id`: The ID of the album.
  - `artist_id`: The ID of the artist.
- **Response**:
  - `200 OK`: A success message indicating the album was removed.
  - `404 Not Found`: If the album is not found.

### Get Albums by Artist ID
- **Endpoint**: `GET /api/created-album/artist-id/{artist_id}`
- **Description**: Retrieves the created albums associated with an artist by their ID.
- **Parameters**:
  - `artist_id`: The ID of the artist.
- **Response**:
  - `200 OK`: A list of created albums associated with the artist.
  - `404 Not Found`: If there are no created albums associated with the artist.

### Get Artists by Album ID
- **Endpoint**: `GET /api/getAlbumArtists/{album_id}`
- **Description**: Retrieves the artists associated with an album by its ID.
- **Parameters**:
  - `album_id`: The ID of the album.
- **Response**:
  - `200 OK`: A list of artists associated with the album.
  - `404 Not Found`: If there are no artists associated with the album.

## Follower Controller

### Add Follower
- **Endpoint**: `POST /api/followers`
- **Description**: Adds a new follower.
- **Request Body**:
  - The `Follower` object.
- **Response**:
  - `201 Created`: A success message indicating the follower was added.
  - `500 Internal Server Error`: If there was an error adding the follower.

### Remove Follower
- **Endpoint**: `DELETE /api/followers/{artist_id}/{user_id}`
- **Description**: Removes a follower.
- **Parameters**:
  - `artist_id`: The ID of the artist.
  - `user_id`: The ID of the user.
- **Response**:
  - `200 OK`: A success message indicating the follower was removed.
  - `404 Not Found`: If the follower is not found.

## Liked Albums Controller

### Add Liked Album
- **Endpoint**: `POST /api/liked-albums`
- **Description**: Adds a liked album.
- **Request Body**:
  - The `LikedAlbums` object.
- **Response**:
  - `201 Created`: A success message indicating the album was liked.
  - `500 Internal Server Error`: If there was an error liking the album.

### Remove Liked Album
- **Endpoint**: `DELETE /api/liked-albums/{user_id}/{album_id}`
- **Description**: Removes a liked album.
- **Parameters**:
  - `user_id`: The ID of the user.
  - `album_id`: The ID of the album.
- **Response**:
  - `200 OK`: A success message indicating the album was unliked.
  - `404 Not Found`: If the liked album is not found.

## Liked Playlists Controller

### Get Liked Playlist
- **Endpoint**: `GET /api/likedplaylists/{userId}/{playlistId}`
- **Description**: Checks if a user has liked a playlist.
- **Parameters**:
  - `userId`: The ID of the user.
  - `playlistId`: The ID of the playlist.
- **Response**:
  - `202 Accepted`: A boolean value indicating whether the user has liked the playlist.

### Create Liked Playlist
- **Endpoint**: `POST /api/likedplaylists`
- **Description**: Creates a new liked playlist.
- **Request Body**:
  - The `LikedPlaylists` object.
- **Response**:
  - `201 Created`: A success message indicating the liked playlist was created.
  - `500 Internal Server Error`: If there was an error creating the liked playlist.

### Delete Liked Playlist
- **Endpoint**: `DELETE /api/likedplaylists/{userId}/{playlistId}`
- **Description**: Deletes a liked playlist.
- **Parameters**:
  - `userId`: The ID of the user.
  - `playlistId`: The ID of the playlist.
- **Response**:
  - `200 OK`: A success message indicating the liked playlist was deleted.
  - `404 Not Found`: If the liked playlist is not found.

## Liked Podcasts Controller

### Add Liked Podcast
- **Endpoint**: `POST /api/liked-podcasts`
- **Description**: Adds a liked podcast.
- **Request Body**:
  - The `LikedPodcasts` object.
- **Response**:
  - `201 Created`: A success message indicating the podcast was liked.
  - `500 Internal Server Error`: If there was an error liking the podcast.

### Remove Liked Podcast
- **Endpoint**: `DELETE /api/liked-podcasts/{user_id}/{podcast_id}`
- **Description**: Removes a liked podcast.
- **Parameters**:
  - `user_id`: The ID of the user.
  - `podcast_id`: The ID of the podcast.
- **Response**:
  - `200 OK`: A success message indicating the podcast was unliked.
  - `404 Not Found`: If the liked podcast is not found.

## Liked Songs Controller

### Get Liked Songs by User ID
- **Endpoint**: `GET /api/likedSongs/userId/{userId}`
- **Description**: Retrieves the liked songs for a given user.
- **Parameters**:
  - `userId`: The ID of the user.
- **Response**:
  - `200 OK`: A list of liked songs.
  - `204 No Content`: If the user has no liked songs.

### Get Liked Song by Track ID
- **Endpoint**: `GET /api/likedSongs/trackId/{trackId}`
- **Description**: Retrieves the liked songs for a given track.
- **Parameters**:
  - `trackId`: The ID of the track.
- **Response**:
  - `200 OK`: A list of liked songs for the given track.
  - `404 Not Found`: If the liked song is not found.

### Save Liked Song
- **Endpoint**: `POST /api/likedSongs`
- **Description**: Saves a new liked song.
- **Request Body**:
  - The `LikedSongs` object.
- **Response**:
  - `201 Created`: A success message indicating the liked song was saved.
  - `500 Internal Server Error`: If there was an error saving the liked song.

## Perks Controller

### Get Perk by Subscription ID
- **Endpoint**: `GET /api/perks/get/{subscriptionId}`
- **Description**: Retrieves a perk by its subscription ID.
- **Parameters**:
  - `subscriptionId`: The ID of the subscription.
- **Response**:
  - `200 OK`: The `Perks` object.
  - `404 Not Found`: If the perk is not found.

### Save Perk
- **Endpoint**: `POST /api/perks`
- **Description**: Saves a new perk.
- **Request Body**:
  - The `Perks` object.
- **Response**:
  - `201 Created`: A success message indicating the perk was saved.
  - `500 Internal Server Error`: If there was an error saving the perk.

### Update Perk
- **Endpoint**: `PUT /api/perks/update/{subscriptionId}`
- **Description**: Updates an existing perk.
- **Parameters**:
  - `subscriptionId`: The ID of the subscription.
- **Request Body**:
  - The updated `Perks` object.
- **Response**:
  - `200 OK`: A success message indicating the perk was updated.
  - `404 Not Found`: If the perk is not found.

### Delete Perk
- **Endpoint**: `DELETE /api/perks/delete/{subscriptionId}`
- **Description**: Deletes a perk.
- **Parameters**:
  - `subscriptionId`: The ID of the subscription.
- **Response**:
  - `200 OK`: A success message indicating the perk was deleted.
  - `404 Not Found`: If the perk is not found.

## Playlist Controller

### GET /api/playlists/{playlistId}
Retrieves a playlist by its ID.

**Parameters:**
- `playlistId`: The ID of the playlist to retrieve.

**Responses:**
- `200 OK`: The requested playlist.
- `404 NOT_FOUND`: The playlist was not found.

### GET /api/playlists/user/{userId}
Retrieves a list of playlists for a given user ID.

**Parameters:**
- `userId`: The ID of the user whose playlists to retrieve.

**Responses:**
- `200 OK`: The list of playlists for the given user.
- `204 NO_CONTENT`: The user has no playlists.

### POST /api/playlists
Creates a new playlist.

**Request Body:**
- `Playlist` object containing the playlist details.

**Responses:**
- `201 CREATED`: The playlist was created successfully.
- `500 INTERNAL_SERVER_ERROR`: An error occurred while creating the playlist.

### PUT /api/playlists/{playlistId}
Updates an existing playlist.

**Parameters:**
- `playlistId`: The ID of the playlist to update.

**Request Body:**
- `Playlist` object containing the updated playlist details.

**Responses:**
- `200 OK`: The playlist was updated successfully.
- `404 NOT_FOUND`: The playlist was not found.

### DELETE /api/playlists/{playlistId}
Deletes a playlist by its ID.

**Parameters:**
- `playlistId`: The ID of the playlist to delete.

**Responses:**
- `200 OK`: The playlist was deleted successfully.
- `404 NOT_FOUND`: The playlist was not found.
- `500 INTERNAL_SERVER_ERROR`: An error occurred while deleting the playlist.

## Playlist Track Controller

### POST /api/playlistsTracks
Adds a track to a playlist.

**Request Body:**
- `PlaylistTrack` object containing the playlist ID and track ID.

**Responses:**
- `201 CREATED`: The track was added to the playlist successfully.
- `500 INTERNAL_SERVER_ERROR`: An error occurred while adding the track to the playlist.

### DELETE /api/playlistsTracks/{playlistId}/{trackId}
Removes a track from a playlist.

**Parameters:**
- `playlistId`: The ID of the playlist.
- `trackId`: The ID of the track to remove.

**Responses:**
- `200 OK`: The track was removed from the playlist successfully.
- `500 INTERNAL_SERVER_ERROR`: An error occurred while removing the track from the playlist.

### GET /api/playlistsTracks/playlist/{playlistId}
Retrieves the tracks for a given playlist.

**Parameters:**
- `playlistId`: The ID of the playlist.

**Responses:**
- `200 OK`: The list of tracks for the given playlist.
- `204 NO_CONTENT`: The playlist has no tracks.

### GET /api/playlistsTracks/track/{trackId}
Retrieves the playlists that a given track belongs to.

**Parameters:**
- `trackId`: The ID of the track.

**Responses:**
- `200 OK`: The list of playlists that the track belongs to.
- `204 NO_CONTENT`: The track is not in any playlists.

## Podcast Controller

### GET /api/podcasts/{id}
Retrieves a podcast by its ID.

**Parameters:**
- `id`: The ID of the podcast to retrieve.

**Responses:**
- `200 OK`: The requested podcast.
- `404 NOT_FOUND`: The podcast was not found.

### POST /api/podcasts
Creates a new podcast.

**Request Body:**
- `Podcast` object containing the podcast details.

**Responses:**
- `201 CREATED`: The podcast was created successfully.
- `500 INTERNAL_SERVER_ERROR`: An error occurred while creating the podcast.

### POST /api/podcasts/{id}
Updates an existing podcast.

**Parameters:**
- `id`: The ID of the podcast to update.

**Request Body:**
- `Podcast` object containing the updated podcast details.

**Responses:**
- `200 OK`: The podcast was updated successfully.
- `404 NOT_FOUND`: The podcast was not found.

### POST /api/podcasts/delete/{id}
Deletes a podcast by its ID.

**Parameters:**
- `id`: The ID of the podcast to delete.

**Responses:**
- `200 OK`: The podcast was deleted successfully.
- `404 NOT_FOUND`: The podcast was not found.
- `500 INTERNAL_SERVER_ERROR`: An error occurred while deleting the podcast.

## Podcast Creator Controller

### GET /api/podcast-creators
Retrieves a list of all podcast creators.

**Responses:**
- `200 OK`: The list of podcast creators.
- `204 NO_CONTENT`: There are no podcast creators.
- `500 INTERNAL_SERVER_ERROR`: An error occurred while retrieving the podcast creators.

### GET /api/podcast-creators/{podcastId}/{artistId}
Retrieves a podcast creator by their podcast ID and artist ID.

**Parameters:**
- `podcastId`: The ID of the podcast.
- `artistId`: The ID of the artist.

**Responses:**
- `200 OK`: The requested podcast creator.
- `404 NOT_FOUND`: The podcast creator was not found.

### POST /api/podcast-creators
Creates a new podcast creator.

**Request Body:**
- `PodcastCreator` object containing the podcast creator details.

**Responses:**
- `201 CREATED`: The podcast creator was created successfully.
- `500 INTERNAL_SERVER_ERROR`: An error occurred while creating the podcast creator.

### PUT /api/podcast-creators/{podcastId}/{artistId}
Updates an existing podcast creator.

**Parameters:**
- `podcastId`: The ID of the podcast.
- `artistId`: The ID of the artist.

**Request Body:**
- `PodcastCreator` object containing the updated podcast creator details.

**Responses:**
- `200 OK`: The podcast creator was updated successfully.
- `500 INTERNAL_SERVER_ERROR`: An error occurred while updating the podcast creator.

### DELETE /api/podcast-creators/{podcastId}/{artistId}
Deletes a podcast creator by their podcast ID and artist ID.

**Parameters:**
- `podcastId`: The ID of the podcast.
- `artistId`: The ID of the artist.

**Responses:**
- `200 OK`: The podcast creator was deleted successfully.
- `404 NOT_FOUND`: The podcast creator was not found.
- `500 INTERNAL_SERVER_ERROR`: An error occurred while deleting the podcast creator.

## Ranking Controller

### POST /api/rankings
Creates a new ranking.

**Request Body:**
- `Ranking` object containing the ranking details.

**Responses:**
- `201 CREATED`: The ranking was created successfully.
- `500 INTERNAL_SERVER_ERROR`: An error occurred while creating the ranking.

### GET /api/rankings/{chartid}
Retrieves the tracks for a given chart ID.

**Parameters:**
- `chartid`: The ID of the chart.

**Responses:**
- `200 OK`: The list of tracks for the given chart.
- `204 NO_CONTENT`: The chart has no tracks.

### DELETE /api/rankings/{chartid}/{trackid}
Deletes a ranking by its chart ID and track ID.

**Parameters:**
- `chartid`: The ID of the chart.
- `trackid`: The ID of the track.

**Responses:**
- `200 OK`: The ranking was deleted successfully.
- `500 INTERNAL_SERVER_ERROR`: An error occurred while deleting the ranking.

### DELETE /api/rankings/{chartid}/{rank}
Deletes a ranking by its chart ID and rank.

**Parameters:**
- `chartid`: The ID of the chart.
- `rank`: The rank of the ranking to delete.

**Responses:**
- `200 OK`: The ranking was deleted successfully.
- `500 INTERNAL_SERVER_ERROR`: An error occurred while deleting the ranking.

## SocialMediaController

### GET /api/socialmedia/{artistId}/{socialMediaType}
- Retrieves a social media record for the specified artist ID and social media type.
- Path Parameters:
  - `artistId`: The ID of the artist.
  - `socialMediaType`: The type of social media (e.g., "Facebook", "Twitter", "Instagram").
- Response:
  - `200 OK`: Returns the found `SocialMedia` object.
  - `404 Not Found`: If the social media record is not found.

### POST /api/socialmedia
- Creates a new social media record.
- Request Body: A `SocialMedia` object.
- Response:
  - `201 Created`: Returns the created `SocialMedia` object.
  - `500 Internal Server Error`: If there is an error creating the social media record.

### PUT /api/socialmedia
- Updates an existing social media record.
- Request Body: A `SocialMedia` object.
- Response:
  - `200 OK`: Returns the updated `SocialMedia` object.
  - `500 Internal Server Error`: If there is an error updating the social media record.

### DELETE /api/socialmedia/{artistId}/{socialMediaType}
- Deletes a social media record for the specified artist ID and social media type.
- Path Parameters:
  - `artistId`: The ID of the artist.
  - `socialMediaType`: The type of social media (e.g., "Facebook", "Twitter", "Instagram").
- Response:
  - `200 OK`: Returns the deleted `SocialMedia` object.
  - `404 Not Found`: If the social media record is not found.

## SubscriptionController

### GET /api/subscriptions/{id}
- Retrieves a subscription record by ID.
- Path Parameters:
  - `id`: The ID of the subscription.
- Response:
  - `200 OK`: Returns the found `Subscription` object.
  - `404 Not Found`: If the subscription is not found.

### POST /api/subscriptions
- Creates a new subscription record.
- Request Body: A `Subscription` object.
- Response:
  - `201 Created`: Returns a success message.
  - `500 Internal Server Error`: If there is an error creating the subscription.

### POST /api/subscriptions/{id}
- Updates an existing subscription record.
- Path Parameters:
  - `id`: The ID of the subscription.
- Request Body: A `Subscription` object.
- Response:
  - `200 OK`: Returns a success message.
  - `404 Not Found`: If the subscription is not found.

### DELETE /api/subscriptions/{id}
- Deletes a subscription record by ID.
- Path Parameters:
  - `id`: The ID of the subscription.
- Response:
  - `200 OK`: Returns a success message.
  - `404 Not Found`: If the subscription is not found.

## TrackController

### GET /api/tracks/{id}
- Retrieves a track by ID.
- Path Parameters:
  - `id`: The ID of the track.
- Response:
  - `200 OK`: Returns the found `Track` object.
  - `404 Not Found`: If the track is not found.

### POST /api/tracks
- Creates a new track.
- Request Body: A `Track` object.
- Response:
  - `201 Created`: Returns a success message.
  - `500 Internal Server Error`: If there is an error creating the track.

### POST /api/tracks/{id}
- Updates an existing track.
- Path Parameters:
  - `id`: The ID of the track.
- Request Body: A `Track` object.
- Response:
  - `200 OK`: Returns a success message.
  - `404 Not Found`: If the track is not found.

### DELETE /api/tracks/{id}
- Deletes a track by ID.
- Path Parameters:
  - `id`: The ID of the track.
- Response:
  - `200 OK`: Returns a success message.
  - `404 Not Found`: If the track is not found.

### GET /api/tracks/albums/{albumId}
- Retrieves all tracks for the specified album ID.
- Path Parameters:
  - `albumId`: The ID of the album.
- Response:
  - `200 OK`: Returns a list of `Track` objects.
  - `204 No Content`: If there are no tracks for the given album ID.

### GET /api/newtracks
- Retrieves the latest (new) tracks.
- Response:
  - `200 OK`: Returns a list of `Track` objects.
  - `204 No Content`: If there are no new tracks.

### GET /api/toppicks
- Retrieves the top pick tracks.
- Response:
  - `200 OK`: Returns a list of `Track` objects.
  - `204 No Content`: If there are no top pick tracks.

## TrackCreatorController

### GET /api/track-creators
- Retrieves all track creators.
- Response:
  - `200 OK`: Returns a list of `TrackCreator` objects.
  - `204 No Content`: If there are no track creators.

### GET /api/track-creators/{trackId}/{artistId}
- Retrieves a track creator by track ID and artist ID.
- Path Parameters:
  - `trackId`: The ID of the track.
  - `artistId`: The ID of the artist.
- Response:
  - `200 OK`: Returns the found `TrackCreator` object.
  - `404 Not Found`: If the track creator is not found.

### POST /api/track-creators
- Creates a new track creator.
- Request Body: A `TrackCreator` object.
- Response:
  - `201 Created`: Returns the created `TrackCreator` object.
  - `500 Internal Server Error`: If there is an error creating the track creator.

### PUT /api/track-creators/{trackId}/{artistId}
- Updates an existing track creator.
- Path Parameters:
  - `trackId`: The ID of the track.
  - `artistId`: The ID of the artist.
- Request Body: A `TrackCreator` object.
- Response:
  - `200 OK`: Returns a success message.
  - `500 Internal Server Error`: If there is an error updating the track creator.

### DELETE /api/track-creators/{trackId}/{artistId}
- Deletes a track creator by track ID and artist ID.
- Path Parameters:
  - `trackId`: The ID of the track.
  - `artistId`: The ID of the artist.
- Response:
  - `200 OK`: Returns a success message.
  - `404 Not Found`: If the track creator is not found.
  - `500 Internal Server Error`: If there is an error deleting the track creator.

### GET /api/getTrackArtists/{trackId}
- Retrieves all artists for a given track ID.
- Path Parameters:
  - `trackId`: The ID of the track.
- Response:
  - `200 OK`: Returns a list of `Artist` objects.
  - `404 Not Found`: If there are no artists found for the given track ID.

## UserController

### GET /api/users
- Retrieves all users.
- Query Parameters:
  - `title`: (Optional) The title to filter the users.
- Response:
  - `200 OK`: Returns a list of `User` objects.
  - `204 No Content`: If there are no users.
  - `500 Internal Server Error`: If there is an error retrieving the users.

### GET /api/users/validate
- Validates the user token and returns the user ID.
- Request Headers:
  - `Authorization`: The JWT token.
- Response:
  - `200 OK`: Returns the user ID.

### GET /api/users/{id}
- Retrieves a user by ID.
- Path Parameters:
  - `id`: The ID of the user.
- Response:
  - `200 OK`: Returns the JWT token for the found `User` object.
  - `404 Not Found`: If the user is not found.

### GET /api/users/profile
- Retrieves the user profile.
- Request Headers:
  - `Authorization`: The JWT token.
- Response:
  - `200 OK`: Returns the `User` object.
  - `404 Not Found`: If the user is not found.

### POST /api/users
- Creates a new user.
- Request Body: A `User` object.
- Response:
  - `201 Created`: Returns a success message.
  - `500 Internal Server Error`: If there is an error creating the user.

### POST /api/login
- Logs in a user.
- Request Body: A `User` object with username and password.
- Response:
  - `200 OK`: Returns the JWT token for the found `User` object.
  - `404 Not Found`: If the user is not found.
  - `500 Internal Server Error`: If there is an error logging in the user.

### GET /api/user/{id}
- Retrieves a user by ID.
- Path Parameters:
  - `id`: The ID of the user.
- Response:
  - `200 OK`: Returns the found `User` object.
  - `404 Not Found`: If the user is not found.