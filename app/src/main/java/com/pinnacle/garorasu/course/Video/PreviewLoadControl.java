package com.pinnacle.garorasu.course.Video;

/**
 * Created by Ideal on 3/27/2017.
 */


import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.util.Util;


public class PreviewLoadControl implements LoadControl {

    private DefaultAllocator allocator;

    public PreviewLoadControl() {
        allocator = new DefaultAllocator(true, C.DEFAULT_BUFFER_SEGMENT_SIZE);
    }

    @Override
    public void onTracksSelected(Renderer[] renderers, TrackGroupArray trackGroups,
                                 TrackSelectionArray trackSelections) {
        int targetBufferSize = 0;
        for (int i = 0; i < renderers.length; i++) {
            if (trackSelections.get(i) != null) {
                targetBufferSize += Util.getDefaultBufferSize(renderers[i].getTrackType());
            }
        }
        allocator.setTargetBufferSize(targetBufferSize);
    }

    @Override
    public Allocator getAllocator() {
        return allocator;
    }

    @Override
    public boolean shouldStartPlayback(long bufferedDurationUs, boolean rebuffering) {
        return bufferedDurationUs >= 1000L * 50; // around 1 frame
    }

    @Override
    public boolean shouldContinueLoading(long bufferedDurationUs) {
        return true;
    }

    @Override
    public void onPrepared() {
        // No-op
    }

    @Override
    public void onStopped() {
        // No-op
    }

    @Override
    public void onReleased() {
        // No-op
    }

}
