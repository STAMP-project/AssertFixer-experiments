/*******************************************************************************
 * Copyright (C) 2018 Joao Sousa
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/

package com.wrapper.spotify;

import com.wrapper.spotify.models.followers.TypeFollow;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class FollowApiTest extends RetrofitTest {

    @Test
    void testCheckIfUserFollows() throws IOException {
        api.follow().checkIfUserFollows(TypeFollow.USER, "exampleuser01").execute();
    }

    @Test
    void testCheckIfUserFollowsPlaylist() throws IOException {
        api.follow().checkIfUserFollowsPlaylist("3cEYpjA9oz9GiPac4AsH4n",
                "jmperezperez,thelinmichael,wizzler").execute();
    }

    @Test
    void testFollow() throws IOException {
        api.follow().follow(TypeFollow.USER, "exampleuser01").execute();
    }

    @Test
    void testFollowPlaylist() throws IOException {
        api.follow().followPlaylist("2v3iNvBX8Ay1Gt2uXtUKUT").execute();
    }

    @Test
    void testGetFollowedArtists() throws IOException {
        api.follow().getFollowedArtists(10).execute();
    }

    @Test
    void testUnfollow() throws IOException {
        api.follow().unfollow(TypeFollow.USER, "exampleuser01").execute();
    }

    @Test
    void testUnfollowPlaylist() throws IOException {
        api.follow().unfollowPlaylist("2v3iNvBX8Ay1Gt2uXtUKUT").execute();
    }
}