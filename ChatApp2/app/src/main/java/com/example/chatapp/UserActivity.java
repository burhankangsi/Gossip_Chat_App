package com.example.chatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chatapp.Fragments.FriendFragment;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserActivity extends AppCompatActivity {
    private RecyclerView mUsersList;
    private DatabaseReference mUsersDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        mUsersList=(RecyclerView)findViewById(R.id.recyclerViewUsersList);
        mUsersList.setHasFixedSize(true);
        mUsersList.setLayoutManager(new LinearLayoutManager(this));

        mUsersDatabaseReference= FirebaseDatabase.getInstance().getReference().child("users");
        mUsersDatabaseReference.keepSynced(true);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        //mUsersDatabaseReference.child(uid).child("online").setValue("true");

//        FirebaseRecyclerOptions<Users> options =
//                new FirebaseRecyclerOptions.Builder<Users>().build();
        Query conversationQuery = mUsersDatabaseReference;

        FirebaseRecyclerOptions<Users> firebaseRecyclerOptions = new FirebaseRecyclerOptions.Builder<Users>()
                .setQuery(conversationQuery, Users.class)
                .build();


        //-------FIREBASE RECYCLE VIEW ADAPTER-------
        FirebaseRecyclerAdapter<Users , UserViewHolder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<Users, UserViewHolder>(
//                Users.class,
//                R.layout.recycle_list_single_user,
//                UserViewHolder.class,
//                mUsersDatabaseReference
                  firebaseRecyclerOptions
        ) {
            @NonNull
            @Override
            public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.recycle_list_single_user, parent, false);

                return new UserViewHolder(view);

            }

            @Override
            protected void onBindViewHolder(@NonNull UserViewHolder viewHolder, int position, @NonNull Users users) {

                viewHolder.setName(users.getName());
                viewHolder.setStatus(users.getStatus());
                viewHolder.setImage(users.getThumbImage(),getApplicationContext());
                final String user_id=getRef(position).getKey();

                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent profileIntent=new Intent(UserActivity.this,Profile.class);
                        profileIntent.putExtra("user_id",user_id);
                        startActivity(profileIntent);
                    }
                });


            }

//            @Override
//            protected void populateViewHolder(UserViewHolder viewHolder, Users users, int position) {
//
//            }
        };
        mUsersList.setAdapter(firebaseRecyclerAdapter);
        firebaseRecyclerAdapter.startListening();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public UserViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setName(String name) {
            TextView userNameView=(TextView)mView.findViewById(R.id.textViewSingleListName);
            userNameView.setText(name);
        }


        public void setStatus(String status) {
            TextView userStatusView=(TextView)mView.findViewById(R.id.textViewSingleListStatus);
            userStatusView.setText(status);
        }

        public void setImage(String thumb_image, Context ctx) {
            CircleImageView userImageView = (CircleImageView)mView.findViewById(R.id.circleImageViewUserImage);
            //Log.e("thumb URL is--- ",thumb_image);
            Picasso.get().load(thumb_image).placeholder(R.drawable.user_img).into(userImageView);
        }
    }

    @Override
    protected void onStop() {
        //String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        //mUsersDatabaseReference.child(uid).child("online").setValue(ServerValue.TIMESTAMP);

        super.onStop();
    }
}
